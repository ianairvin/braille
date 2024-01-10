package ru.braille.presentation.main_elements_app

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import ru.braille.color.surfaceContainerDark
import ru.braille.color.surfaceContainerLight
import ru.braille.R
import ru.braille.presentation.list_lessons_screen.ListLessonsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(
    badgeCountLearning: MutableState<Int>,
    navController: NavHostController,
    selectedItem: MutableState<String>
) {
    NavigationBar(
        containerColor = if(isSystemInDarkTheme()) surfaceContainerDark
        else surfaceContainerLight
    ) {
        NavigationBarItem(
            selected = selectedItem.value == "list_lessons" ||
                    selectedItem.value ==  "lesson" ||
                    selectedItem.value == "repeat",
            onClick = {
                if(navController.currentDestination?.route != "lesson") {
                    navController.navigate("list_lessons") {
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                    selectedItem.value = "list_lessons"
                }
            },
            label = { Text("Обучение") },
            icon = {
                BadgedBox(badge = {
                    if(badgeCountLearning.value != 0){
                        Badge{
                            Text(text = badgeCountLearning.value.toString())
                        }
                    }
                })
                {
                    Icon(
                        painter = painterResource(id = R.drawable.learning),
                        contentDescription = null
                    )
                } },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = if(isSystemInDarkTheme()) MaterialTheme.colorScheme.secondaryContainer
                else MaterialTheme.colorScheme.secondary,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                selectedTextColor = if(isSystemInDarkTheme()) MaterialTheme.colorScheme.secondaryContainer
                else MaterialTheme.colorScheme.secondary,
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                indicatorColor = if(isSystemInDarkTheme()) surfaceContainerDark
                else surfaceContainerLight
            )
        )
        NavigationBarItem(
            selected = selectedItem.value == "exerciser",
            onClick = {
                navController.navigate("exerciser") {
                    popUpTo(navController.graph.id) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
                selectedItem.value = "exerciser"
            },
            label = { Text("Тренажер") },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.exerciser),
                    contentDescription = null
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = if(isSystemInDarkTheme()) MaterialTheme.colorScheme.secondaryContainer
                else MaterialTheme.colorScheme.secondary,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                selectedTextColor = if(isSystemInDarkTheme()) MaterialTheme.colorScheme.secondaryContainer
                else MaterialTheme.colorScheme.secondary,
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                indicatorColor = if(isSystemInDarkTheme()) surfaceContainerDark
                else surfaceContainerLight
            )
        )
        NavigationBarItem(
            selected = selectedItem.value == "dictionary",
            onClick = {
                navController.navigate("dictionary") {
                    popUpTo(navController.graph.id) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
                selectedItem.value = "dictionary"
            },
            label = { Text("Словарь") },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.dictionary),
                    contentDescription = null
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = if(isSystemInDarkTheme()) MaterialTheme.colorScheme.secondaryContainer
                else MaterialTheme.colorScheme.secondary,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                selectedTextColor = if(isSystemInDarkTheme()) MaterialTheme.colorScheme.secondaryContainer
                else MaterialTheme.colorScheme.secondary,
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                indicatorColor = if(isSystemInDarkTheme()) surfaceContainerDark
                else surfaceContainerLight
            )
        )
    }
}