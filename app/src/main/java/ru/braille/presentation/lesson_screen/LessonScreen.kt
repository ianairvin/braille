package ru.braille.presentation.lesson_screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.braille.R
import ru.braille.domain.entities.Symbol
import ru.braille.presentation.list_lessons_screen.ListLessonsVM
import ru.braille.presentation.main_elements_app.TopBar
import ru.braille.ui.theme.InterFamily

@Composable
fun LessonScreen(
    navController: NavHostController,
    selectedItem: MutableState<String>,
    badgeCountLearning: MutableState<Int>,
    lessonVM: LessonVM,
    listLessonsVM: ListLessonsVM,
    tabIndex: MutableState<Int>
) {
    if(lessonVM.selectedLesson.value != listLessonsVM.selectedLesson.value){
        lessonVM.selectedLesson.value = listLessonsVM.selectedLesson.value
        lessonVM.getSymbols()
        lessonVM.wasLessonComplete()
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(navController, selectedItem, badgeCountLearning, tabIndex)
        SurfaceSymbolLesson(
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
            lessonVM.listFirstShow,
            lessonVM.islistFirstShowEmpty
        )
    }
}

@Composable
fun SurfaceSymbolLesson(
    selectedLesson: MutableState<Int>,
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
    listFirstShow: MutableState<MutableList<Symbol>>,
    islistFirstShowEmpty: MutableState<Boolean>
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(start = 32.dp, end = 32.dp, top = 32.dp, bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if(wasLessonComplete.value) {
            Warning(wasLessonComplete, lessonVM)
        } else if(noSymbols.value){
            NoSymbols()
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
                selectedLesson,
                listFirstShow,
                islistFirstShowEmpty
            )
        }
    }
}

@Composable
fun Warning(
    wasLessonComplete: MutableState<Boolean>,
    lessonVM: LessonVM
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            fontFamily = InterFamily,
            fontSize = 16.sp,
            text = "Начиная урок заново"
        )
        Text(
            fontFamily = InterFamily,
            fontSize = 16.sp,
            text = "весь прогресс будет утерян"
        )
        Spacer(Modifier.padding(bottom = 32.dp))
        Button(
            onClick = {
                wasLessonComplete.value = false
                lessonVM.updateLesson()
            }
        ){
            Text(
                text = "Продолжить",
                fontFamily = InterFamily
            )
        }
    }
}

@Composable
fun NoSymbols(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            fontFamily = InterFamily,
            fontSize = 16.sp,
            text = "Нет символов для изучения"
        )
    }
}
