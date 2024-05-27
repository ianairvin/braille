package ru.braille.presentation.lesson_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.braille.domain.entities.Symbol
import ru.braille.presentation.exerciser_screen.ExerciserVM
import ru.braille.presentation.list_lessons_screen.ListLessonsVM
import ru.braille.presentation.main_elements_app.TopBar
import ru.braille.presentation.theme.InterFamily

@Composable
fun LessonScreen(
    navController: NavHostController,
    selectedItem: MutableState<String>,
    badgeCountLearning: MutableState<Int>,
    lessonVM: LessonVM,
    exerciserVM: ExerciserVM,
    listLessonsVM: ListLessonsVM,
    tabIndex: MutableState<Int>
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(navController, selectedItem, badgeCountLearning, tabIndex)
        SurfaceSymbolLesson(
            listLessonsVM.selectedLesson,
            lessonVM.selectedLesson,
            lessonVM.symbolsLesson,
            lessonVM.symbolsAreNotLearning,
            lessonVM.currentSymbol,
            lessonVM.dot1,
            lessonVM.dot2,
            lessonVM.dot3,
            lessonVM.dot4,
            lessonVM.dot5,
            lessonVM.dot6,
            lessonVM,
            lessonVM.wasWrongButtonPush,
            lessonVM.wasSymbolRight,
            lessonVM.wasSymbolWrong,
            lessonVM.wasLessonComplete,
            navController,
            lessonVM.noSymbols,
            lessonVM.islistFirstShowEmpty,
            exerciserVM,
            lessonVM.lessonOver
        )
    }
}

@Composable
fun SurfaceSymbolLesson(
    selectedLessonFromListLessonVM: MutableState<Int>,
    selectedLessonFromLessonVM: MutableState<Int>,
    symbolsLesson: MutableState<List<Symbol>>,
    symbolsAreNotLearning: MutableState<MutableList<Symbol>>,
    currentSymbol: MutableState<Symbol>,
    dot1: MutableState<Boolean>,
    dot2: MutableState<Boolean>,
    dot3: MutableState<Boolean>,
    dot4: MutableState<Boolean>,
    dot5: MutableState<Boolean>,
    dot6: MutableState<Boolean>,
    lessonVM: LessonVM,
    wasWrongButtonPush: MutableState<Boolean>,
    wasSymbolRight: MutableState<Boolean>,
    wasSymbolWrong: MutableState<Boolean>,
    wasLessonComplete: MutableState<Boolean>,
    navController: NavHostController,
    noSymbols: MutableState<Boolean>,
    islistFirstShowEmpty: MutableState<Boolean>,
    exerciserVM: ExerciserVM,
    lessonOver: MutableState<Boolean>
) {
    if (selectedLessonFromLessonVM.value != selectedLessonFromListLessonVM.value) {
        selectedLessonFromLessonVM.value = selectedLessonFromListLessonVM.value
        lessonVM.getSymbols()
        lessonVM.lessonComplete()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 32.dp, end = 32.dp, top = 32.dp, bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (noSymbols.value) {
            NoSymbols(navController)
        } else if (lessonOver.value) {
            LessonOver(
                lessonOver,
                navController,
                noSymbols,
                wasLessonComplete,
                selectedLessonFromLessonVM
            )
        } else if (wasLessonComplete.value && !lessonOver.value) {
            Warning(
                wasLessonComplete,
                lessonVM,
                navController
            )
        } else {
            SampleCard(
                currentSymbol,
                dot1,
                dot2,
                dot3,
                dot4,
                dot5,
                dot6,
                lessonVM,
                wasSymbolRight,
                wasWrongButtonPush,
                wasSymbolWrong,
                navController,
                symbolsAreNotLearning,
                wasLessonComplete,
                symbolsLesson,
                selectedLessonFromLessonVM,
                islistFirstShowEmpty,
                exerciserVM
            )
        }
    }
}

@Composable
fun Warning(
    wasLessonComplete: MutableState<Boolean>,
    lessonVM: LessonVM,
    navController: NavHostController
) {
    Text(
        fontFamily = InterFamily,
        fontSize = 16.sp,
        text = "Начиная урок заново,"
    )
    Text(
        fontFamily = InterFamily,
        fontSize = 16.sp,
        text = "весь прогресс будет утерян"
    )
    Spacer(Modifier.padding(bottom = 32.dp))
    Row() {
        OutlinedButton(
            onClick = {
                navController.navigate("list_lessons")
            }
        ) {
            Text(
                text = "Назад",
                fontFamily = InterFamily
            )
        }
        Spacer(Modifier.padding(start = 16.dp))
        Button(
            onClick = {
                wasLessonComplete.value = false
                lessonVM.resetLesson()
                lessonVM.updateSymbolsAfterReset()
            }
        ) {
            Text(
                text = "Продолжить",
                fontFamily = InterFamily
            )
        }
    }
}

@Composable
fun NoSymbols(
    navController: NavHostController
) {
    Text(
        fontFamily = InterFamily,
        fontSize = 16.sp,
        text = "Нет символов для изучения"
    )
    Spacer(Modifier.padding(bottom = 32.dp))
    Button(
        onClick = {
            navController.navigate("list_lessons")
        }
    ) {
        Text(
            text = "Назад",
            fontFamily = InterFamily
        )
    }
}

@Composable
fun LessonOver(
    lessonOver: MutableState<Boolean>,
    navController: NavHostController,
    noSymbols: MutableState<Boolean>,
    wasLessonComplete: MutableState<Boolean>,
    selectedLessonFromLessonVM: MutableState<Int>
) {
    Text(
        fontFamily = InterFamily,
        fontSize = 16.sp,
        text = "Урок завершен"
    )
    Spacer(Modifier.padding(bottom = 32.dp))
    Button(
        onClick = {
            wasLessonComplete.value = false
            lessonOver.value = false
            noSymbols.value = false
            selectedLessonFromLessonVM.value = 0
            navController.navigate("list_lessons")
        }
    ) {
        Text(
            text = "Назад",
            fontFamily = InterFamily
        )
    }
}