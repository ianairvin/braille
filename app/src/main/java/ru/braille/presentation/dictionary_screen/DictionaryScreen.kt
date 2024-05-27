package ru.braille.presentation.dictionary_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.braille.presentation.theme.InterFamily

@Composable
fun DictionaryScreen(
    dictionaryVM: DictionaryVM,
    openAlertDialog: MutableState<Boolean>
) {
    val interactionSource = remember { MutableInteractionSource() }
    val list = remember { dictionaryVM.symbols }

    val scrollState = rememberScrollState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = if (openAlertDialog.value) {
            Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp)
                .verticalScroll(scrollState)
                .clickable(
                    interactionSource = interactionSource,
                    onClick = { openAlertDialog.value = false },
                    indication = null
                )
        } else {
            Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp)
                .verticalScroll(scrollState)
        }
    ) {
        list.forEach { buttonGroup ->
            ButtonRow(buttonGroup, openAlertDialog, dictionaryVM)
            if (list.last() != buttonGroup) {
                HorizontalDivider(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
            }
        }
        if (openAlertDialog.value) SymbolAlertDialog(openAlertDialog, dictionaryVM.openSymbol.value)
    }
}

@Composable
fun ButtonRow(
    buttonGroup: List<String>,
    openAlertDialog: MutableState<Boolean>,
    dictionaryVM: DictionaryVM
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        buttonGroup.forEach { buttonText ->
            ElevatedButton(
                onClick = {
                    openAlertDialog.value = true
                    dictionaryVM.getSymbol(buttonText)
                },
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top = 8.dp)
                    .width(60.dp)
                    .height(60.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 4.dp
                ),
                shape = ShapeDefaults.Medium,
                content = {
                    Text(
                        text = buttonText,
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp,
                        fontFamily = InterFamily,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            )
        }
    }
}