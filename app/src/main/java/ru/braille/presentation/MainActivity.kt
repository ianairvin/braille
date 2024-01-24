package ru.braille.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import ru.braille.presentation.dictionary_screen.DictionaryVM
import ru.braille.presentation.exerciser_screen.ExerciserVM
import ru.braille.presentation.lesson_screen.LessonVM
import ru.braille.presentation.list_lessons_screen.ListLessonsVM
import ru.braille.presentation.main_elements_app.AppNavHost
import ru.braille.presentation.main_elements_app.BottomBar
import ru.braille.presentation.statistics_screen.StatisticsVM
import ru.braille.ui.theme.BrailleTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val listLessonsViewModel by viewModels<ListLessonsVM>()
    private val lessonViewModel by viewModels<LessonVM>()
    private val dictionaryViewModel by viewModels<DictionaryVM>()
    private val exerciserViewModel by viewModels<ExerciserVM>()
    private val statisticsViewModel by viewModels<StatisticsVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            BrailleTheme {
                UiController(isSystemInDarkTheme())
                val badgeCountLearning = remember{ mutableStateOf(1) }
                val selectedItem = remember{ mutableStateOf("list_lessons") }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomBar(badgeCountLearning, navController, selectedItem) }
                ) { contentPadding ->
                    Column(
                        modifier = Modifier
                            .padding(contentPadding)
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        AppNavHost(
                            navController,
                            badgeCountLearning,
                            listLessonsViewModel,
                            lessonViewModel,
                            dictionaryViewModel,
                            exerciserViewModel,
                            statisticsViewModel)
                    }
                }
            }
        }
    }
}


@Composable
fun UiController(darkTheme: Boolean){
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(color = Color.Transparent)
        systemUiController.statusBarDarkContentEnabled = !darkTheme
        systemUiController.setNavigationBarColor(color =
        if (darkTheme) ru.braille.color.surfaceContainerDark
        else ru.braille.color.surfaceContainerLight)
        systemUiController.navigationBarDarkContentEnabled = !darkTheme
    }
}