package ru.braille.presentation.main_elements_app

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.braille.presentation.list_lessons_screen.ListLessonsScreen
import ru.braille.presentation.list_lessons_screen.ListLessonsVM

@Composable
fun AppNavHost(
    navController: NavHostController,
    badgeCountLearning: MutableState<Int>,
    listLessonsVM: ListLessonsVM
){
    val selectedItem = remember { mutableStateOf("list_lessons") }

    NavHost(navController = navController, startDestination = "list_lessons") {

        composable(route = "list_lessons"){
            ListLessonsScreen(
                navController,
                selectedItem,
                badgeCountLearning,
                listLessonsVM)
        }
        composable(route = "lesson"){
            //LessonScreen(contentPadding)
           // ListLessonsScreen(navController, selectedItem)
        }
        composable(route = "repeat"){
            //RepeatScreen(contentPadding)
          //  ListLessonsScreen(navController, selectedItem)
        }
        composable(route = "exerciser"){
            //ExerciserScreen(contentPadding)
            //navController.popBackStack()
           // ListLessonsScreen(navController, selectedItem)

        }
        composable(route = "dictionary"){
            //DictionaryScreen(contentPadding)
            //navController.popBackStack()
           // ListLessonsScreen(navController, selectedItem)
        }
    }
}