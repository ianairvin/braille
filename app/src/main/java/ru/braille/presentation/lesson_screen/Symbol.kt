package ru.braille.presentation.lesson_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.braille.R
import ru.braille.domain.entities.Symbol
import ru.braille.presentation.theme.InterFamily

@Composable
fun SymbolShow(
    currentSymbol: MutableState<Symbol>,
    dot1: MutableState<Boolean>,
    dot2: MutableState<Boolean>,
    dot3: MutableState<Boolean>,
    dot4: MutableState<Boolean>,
    dot5: MutableState<Boolean>,
    dot6: MutableState<Boolean>,
    wasSymbolRight: MutableState<Boolean>,
    wasWrongButtonPush: MutableState<Boolean>
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = currentSymbol.value.symbol,
            fontSize = 64.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = InterFamily
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(
                    id = if (dot1.value)
                        R.drawable.fill_circle
                    else R.drawable.outline_circle
                ),
                contentDescription = null,
                modifier =
                if (wasSymbolRight.value || wasWrongButtonPush.value) {
                    Modifier.height(54.dp)
                        .width(54.dp)
                        .padding(6.dp, 0.dp, 6.dp, 0.dp)
                } else {
                    Modifier.height(54.dp)
                        .width(54.dp)
                        .padding(6.dp, 0.dp, 6.dp, 0.dp)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = {
                                dot1.value = !dot1.value
                            })
                },
                tint = MaterialTheme.colorScheme.primary
            )
            Icon(
                painter = painterResource(
                    id = if (dot2.value)
                        R.drawable.fill_circle
                    else R.drawable.outline_circle
                ),
                contentDescription = null,
                modifier =
                if (wasSymbolRight.value || wasWrongButtonPush.value) {
                    Modifier.height(54.dp)
                        .width(54.dp)
                        .padding(6.dp, 0.dp, 6.dp, 0.dp)
                } else {
                    Modifier.height(54.dp)
                        .width(54.dp)
                        .padding(6.dp, 0.dp, 6.dp, 0.dp)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = {
                                dot2.value = !dot2.value
                            })
                },
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(
                    id = if (dot3.value)
                        R.drawable.fill_circle
                    else R.drawable.outline_circle
                ),
                contentDescription = null,
                modifier =
                if (wasSymbolRight.value || wasWrongButtonPush.value) {
                    Modifier.height(54.dp)
                        .width(54.dp)
                        .padding(6.dp, 0.dp, 6.dp, 0.dp)
                } else {
                    Modifier.height(54.dp)
                        .width(54.dp)
                        .padding(6.dp, 0.dp, 6.dp, 0.dp)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = {
                                dot3.value = !dot3.value
                            })
                },
                tint = MaterialTheme.colorScheme.primary
            )
            Icon(
                painter = painterResource(
                    id = if (dot4.value)
                        R.drawable.fill_circle
                    else R.drawable.outline_circle
                ),
                contentDescription = null,
                modifier =
                if (wasSymbolRight.value || wasWrongButtonPush.value) {
                    Modifier.height(54.dp)
                        .width(54.dp)
                        .padding(6.dp, 0.dp, 6.dp, 0.dp)
                } else {
                    Modifier.height(54.dp)
                        .width(54.dp)
                        .padding(6.dp, 0.dp, 6.dp, 0.dp)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = {
                                dot4.value = !dot4.value
                            })
                },
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(
                    id = if (dot5.value)
                        R.drawable.fill_circle
                    else R.drawable.outline_circle
                ),
                contentDescription = null,
                modifier =
                if (wasSymbolRight.value || wasWrongButtonPush.value) {
                    Modifier.height(54.dp)
                        .width(54.dp)
                        .padding(6.dp, 0.dp, 6.dp, 0.dp)
                } else {
                    Modifier.height(54.dp)
                        .width(54.dp)
                        .padding(6.dp, 0.dp, 6.dp, 0.dp)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = {
                                dot5.value = !dot5.value
                            })
                },
                tint = MaterialTheme.colorScheme.primary
            )
            Icon(
                painter = painterResource(
                    id = if (dot6.value)
                        R.drawable.fill_circle
                    else R.drawable.outline_circle
                ),
                contentDescription = null,
                modifier =
                if (wasSymbolRight.value || wasWrongButtonPush.value) {
                    Modifier.height(54.dp)
                        .width(54.dp)
                        .padding(6.dp, 0.dp, 6.dp, 0.dp)
                } else {
                    Modifier.height(54.dp)
                        .width(54.dp)
                        .padding(6.dp, 0.dp, 6.dp, 0.dp)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = {
                                dot6.value = !dot6.value
                            })
                },
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}