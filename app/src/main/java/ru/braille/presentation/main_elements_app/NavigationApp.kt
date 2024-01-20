package ru.braille.presentation.main_elements_app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.braille.presentation.dictionary.DictionaryScreen
import ru.braille.presentation.dictionary.DictionaryVM
import ru.braille.presentation.lesson_screen.LessonScreen
import ru.braille.presentation.lesson_screen.LessonVM
import ru.braille.presentation.list_lessons_screen.ListLessonsScreen
import ru.braille.presentation.list_lessons_screen.ListLessonsVM

@Composable
fun AppNavHost(
    navController: NavHostController,
    badgeCountLearning: MutableState<Int>,
    listLessonsVM: ListLessonsVM,
    lessonVM: LessonVM,
    dictionaryVM: DictionaryVM
){
    val selectedItem = remember { mutableStateOf("list_lessons") }
    val tabIndex = remember { mutableStateOf(0) }
    val selectedLesson = remember { mutableStateOf(0) }

    NavHost(navController = navController, startDestination = "list_lessons") {

        composable(route = "list_lessons"){
            ListLessonsScreen(
                navController,
                selectedItem,
                badgeCountLearning,
                listLessonsVM,
                tabIndex,
                selectedLesson
                )
        }
        composable(route = "lesson"){
            LessonScreen(
                navController,
                selectedItem,
                badgeCountLearning,
                lessonVM,
                tabIndex,
                selectedLesson
            )
        }
        composable(route = "repeat"){
            //RepeatScreen(contentPadding)
        }
        composable(route = "exerciser"){
            //ExerciserScreen(contentPadding)

        }
        composable(route = "dictionary"){
            DictionaryScreen(dictionaryVM)
        }
    }
}