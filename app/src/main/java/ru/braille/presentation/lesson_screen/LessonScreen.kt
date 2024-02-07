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

@Composable
fun LessonScreen(
    navController: NavHostController,
    selectedItem: MutableState<String>,
    badgeCountLearning: MutableState<Int>,
    lessonVM: LessonVM,
    listLessonsVM: ListLessonsVM,
    tabIndex: MutableState<Int>
) {
    lessonVM.selectedLesson.value = listLessonsVM.selectedLesson.value
    lessonVM.getSymbols()
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
        )
    }
}