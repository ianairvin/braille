package ru.braille.presentation.repeat_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.braille.domain.entities.Symbol
import ru.braille.presentation.main_elements_app.TopBar
import ru.braille.presentation.theme.InterFamily

@Composable
fun RepeatScreen(
    navController: NavHostController,
    selectedItem: MutableState<String>,
    badgeCountLearning: MutableState<Int>,
    repeatVM: RepeatVM,
    tabIndex: MutableState<Int>,
    openAlertDialogRepeatHelper: MutableState<Boolean>
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(navController, selectedItem, badgeCountLearning, tabIndex)
        SurfaceSymbolRepeat(
            repeatVM.currentSymbol,
            repeatVM.dot1,
            repeatVM.dot2,
            repeatVM.dot3,
            repeatVM.dot4,
            repeatVM.dot5,
            repeatVM.dot6,
            repeatVM,
            repeatVM.wasWrongButtonPush,
            repeatVM.wasSymbolRight,
            repeatVM.wasSymbolWrong,
            repeatVM.noSymbols,
            repeatVM.numberOfRepeats,
            openAlertDialogRepeatHelper
        )
    }
}

@Composable
fun SurfaceSymbolRepeat(
    currentSymbol: MutableState<Symbol>,
    dot1: MutableState<Boolean>,
    dot2: MutableState<Boolean>,
    dot3: MutableState<Boolean>,
    dot4: MutableState<Boolean>,
    dot5: MutableState<Boolean>,
    dot6: MutableState<Boolean>,
    repeatVM: RepeatVM,
    wasWrongButtonPush: MutableState<Boolean>,
    wasSymbolRight: MutableState<Boolean>,
    wasSymbolWrong: MutableState<Boolean>,
    noSymbols: MutableState<Boolean>,
    numberOfRepeats: MutableState<Int>,
    openAlertDialog: MutableState<Boolean>
) {
    Column(
        modifier = if (openAlertDialog.value) {
            Modifier
                .fillMaxSize()
                .padding(start = 32.dp, end = 32.dp, top = 32.dp, bottom = 32.dp)
                .clickable(
                    interactionSource = interactionSource,
                    onClick = { openAlertDialog.value = false },
                    indication = null
                )
                .blur(4.dp)
        } else {
            Modifier
                .fillMaxSize()
                .padding(start = 32.dp, end = 32.dp, top = 32.dp, bottom = 32.dp)
        },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (openAlertDialog.value) {
            HelpSurface(openAlertDialog)
        }
        NoSymbols(noSymbols)
        SampleCard(
            currentSymbol,
            dot1,
            dot2,
            dot3,
            dot4,
            dot5,
            dot6,
            repeatVM,
            wasSymbolRight,
            wasWrongButtonPush,
            wasSymbolWrong,
            numberOfRepeats,
            openAlertDialog
        )
    }
}

@Composable
fun NoSymbols(
    noSymbols: MutableState<Boolean>
) {
    if (noSymbols.value) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                fontFamily = InterFamily,
                fontSize = 16.sp,
                text = "Нет символов для повторения",
                color = Color.Gray
            )
        }
    }
}