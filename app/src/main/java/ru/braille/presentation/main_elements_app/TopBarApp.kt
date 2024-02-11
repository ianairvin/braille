package ru.braille.presentation.main_elements_app

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.braille.R
import ru.braille.ui.theme.InterFamily

@Composable
fun TopBar(
    navController: NavHostController,
    selectedItem: MutableState<String>,
    badgeCountLearning: MutableState<Int>,
    tabIndex: MutableState<Int>
){
    Spacer(modifier = Modifier.padding(bottom = 16.dp))
    TabRow(
        selectedTabIndex = tabIndex.value
    ) {
        Tab(
            selected = tabIndex.value == 0,
            onClick = {
                if(selectedItem.value != "lesson") {
                    tabIndex.value = 0
                    selectedItem.value = "list_lessons"
                    navController.navigate("list_lessons") {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
            text = { Text(
                text = "Уроки",
                fontFamily = InterFamily
            ) }
        )
        Tab(
            selected = tabIndex.value == 1,
            onClick = {
                tabIndex.value = 1
                selectedItem.value = "repeat"
                navController.navigate("repeat") {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            text = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Повторение",
                        fontFamily = InterFamily)
                    Spacer(modifier = Modifier.padding(end = 4.dp))
                    if (badgeCountLearning.value != 0) {
                        Icon(
                            painter = painterResource(id = R.drawable.fill_circle),
                            contentDescription = null,
                            tint = colorScheme.error
                        )
                    }
                }
            },
        )
    }
}
