package ru.braille.presentation.list_lessons_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.braille.domain.entities.Lesson
import ru.braille.presentation.main_elements_app.TopBar
import ru.braille.presentation.theme.InterFamily
import ru.braille.presentation.theme.primaryDarkContainerOutlinedButton
import ru.braille.presentation.theme.primaryLightContainerOutlinedButton

@Composable
fun ListLessonsScreen(
    navController: NavHostController,
    selectedItem: MutableState<String>,
    badgeCountLearning: MutableState<Int>,
    listLessonsVM: ListLessonsVM,
    tabIndex: MutableState<Int>
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(navController, selectedItem, badgeCountLearning, tabIndex)
        Column(modifier = Modifier.weight(8f)) {
            ListLessons(
                listLessonsVM.listLessons.collectAsState(initial = emptyList()),
                navController,
                listLessonsVM.selectedLesson
            )
        }
    }
}


@Composable
fun ListLessons(
    listLessons: State<List<Lesson>>,
    navController: NavHostController,
    selectedLesson: MutableState<Int>
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        listLessons.value.forEach { item ->
            if (item.number == 1) {
                Spacer(modifier = Modifier.padding(12.dp))
            }
            if (item.completed) {
                Button(
                    onClick = {
                        selectedLesson.value = item.number
                        navController.navigate("lesson") {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    modifier = Modifier.width(280.dp)
                ) {
                    Text(
                        text = "Урок ${item.number}\nБуквы ${item.symbol1}, ${item.symbol2} и ${item.symbol3}",
                        textAlign = TextAlign.Center,
                        fontFamily = InterFamily
                    )
                }
            } else {
                OutlinedButton(
                    onClick = {
                        selectedLesson.value = item.number
                        navController.navigate("lesson") {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    border = BorderStroke(
                        width = 1.dp,
                        color = colorScheme.primary
                    ),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (isSystemInDarkTheme())
                            primaryDarkContainerOutlinedButton
                        else
                            primaryLightContainerOutlinedButton
                    ),
                    modifier = Modifier.width(280.dp)
                ) {
                    Text(
                        text = "Урок ${item.number}\nБуквы ${item.symbol1}, ${item.symbol2} и ${item.symbol3}",
                        textAlign = TextAlign.Center,
                        fontFamily = InterFamily
                    )

                }
            }
            Spacer(modifier = Modifier.padding(12.dp))
        }
    }
}

