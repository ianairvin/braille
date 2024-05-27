package ru.braille.presentation.main_elements_app

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import ru.braille.R
import ru.braille.presentation.theme.InterFamily
import ru.braille.presentation.theme.surfaceContainerDark
import ru.braille.presentation.theme.surfaceContainerLight

@Composable
fun BottomBar(
    badgeCountLearning: MutableState<Int>,
    navController: NavHostController,
    selectedItem: MutableState<String>
) {
    NavigationBar(
        containerColor = if (isSystemInDarkTheme()) surfaceContainerDark
        else surfaceContainerLight
    ) {
        NavigationBarItem(
            selected = selectedItem.value == "exerciser",
            onClick = {
                navController.navigate("exerciser") {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
                selectedItem.value = "exerciser"
            },
            label = {
                Text(
                    text = "Тренажер",
                    fontFamily = InterFamily
                )
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.exerciser),
                    contentDescription = null
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = colorScheme.primary,
                unselectedIconColor = colorScheme.onSurfaceVariant,
                selectedTextColor = colorScheme.primary,
                unselectedTextColor = colorScheme.onSurfaceVariant,
                indicatorColor = if (isSystemInDarkTheme()) surfaceContainerDark
                else surfaceContainerLight
            )
        )

        NavigationBarItem(
            selected = selectedItem.value == "list_lessons" ||
                    selectedItem.value == "lesson" ||
                    selectedItem.value == "repeat",
            onClick = {
                navController.navigate("list_lessons") {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
                selectedItem.value = "list_lessons"
            },
            label = {
                Text(
                    text = "Обучение",
                    fontFamily = InterFamily
                )
            },
            icon = {
                BadgedBox(badge = {
                    if (badgeCountLearning.value != 0) {
                        Badge {
                            Text(text = badgeCountLearning.value.toString())
                        }
                    }
                })
                {
                    Icon(
                        painter = painterResource(id = R.drawable.learning),
                        contentDescription = null
                    )
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = colorScheme.primary,
                unselectedIconColor = colorScheme.onSurfaceVariant,
                selectedTextColor = colorScheme.primary,
                unselectedTextColor = colorScheme.onSurfaceVariant,
                indicatorColor = if (isSystemInDarkTheme()) surfaceContainerDark
                else surfaceContainerLight
            )
        )

        NavigationBarItem(
            selected = selectedItem.value == "dictionary",
            onClick = {
                navController.navigate("dictionary") {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
                selectedItem.value = "dictionary"
            },
            label = {
                Text(
                    text = "Словарь",
                    fontFamily = InterFamily
                )
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.dictionary),
                    contentDescription = null
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = colorScheme.primary,
                unselectedIconColor = colorScheme.onSurfaceVariant,
                selectedTextColor = colorScheme.primary,
                unselectedTextColor = colorScheme.onSurfaceVariant,
                indicatorColor = if (isSystemInDarkTheme()) surfaceContainerDark
                else surfaceContainerLight
            )
        )
    }
}