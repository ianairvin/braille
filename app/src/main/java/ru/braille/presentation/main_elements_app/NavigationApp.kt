package ru.braille.presentation.main_elements_app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.braille.presentation.dictionary_screen.DictionaryScreen
import ru.braille.presentation.dictionary_screen.DictionaryVM
import ru.braille.presentation.exerciser_screen.ExerciserScreen
import ru.braille.presentation.exerciser_screen.ExerciserVM
import ru.braille.presentation.lesson_screen.LessonScreen
import ru.braille.presentation.lesson_screen.LessonVM
import ru.braille.presentation.list_lessons_screen.ListLessonsScreen
import ru.braille.presentation.list_lessons_screen.ListLessonsVM
import ru.braille.presentation.statistics_screen.StatisticsScreen
import ru.braille.presentation.statistics_screen.StatisticsVM

@Composable
fun AppNavHost(
    navController: NavHostController,
    badgeCountLearning: MutableState<Int>,
    listLessonsVM: ListLessonsVM,
    lessonVM: LessonVM,
    dictionaryVM: DictionaryVM,
    exerciserVM: ExerciserVM,
    statisticsVM: StatisticsVM
){
    val selectedItem = remember { mutableStateOf("list_lessons") }
    val tabIndex = remember { mutableStateOf(0) }

    NavHost(navController = navController, startDestination = "list_lessons") {

        composable(route = "list_lessons"){
            ListLessonsScreen(
                navController,
                selectedItem,
                badgeCountLearning,
                listLessonsVM,
                tabIndex
                )
        }
        composable(route = "lesson"){
            LessonScreen(
                navController,
                selectedItem,
                badgeCountLearning,
                lessonVM,
                exerciserVM,
                listLessonsVM,
                tabIndex
            )
        }
        composable(route = "repeat"){
            //RepeatScreen(contentPadding)
        }
        composable(route = "exerciser"){
            ExerciserScreen(navController, exerciserVM)
        }
        composable(route = "statistics"){
            StatisticsScreen(statisticsVM)
        }
        composable(route = "dictionary"){
            DictionaryScreen(dictionaryVM)
        }
    }
}