package ru.braille.presentation.repeat_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.braille.R
import ru.braille.domain.entities.Symbol
import ru.braille.presentation.exerciser_screen.ExerciserVM
import ru.braille.ui.theme.InterFamily

val interactionSource = MutableInteractionSource()

@Composable
fun SampleCard(
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
    numberOfRepeats: MutableState<Int>,
    openAlertDialog: MutableState<Boolean>
){
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 12.dp, end = 16.dp)
                    .weight(0.35f)
            ) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Повторение №${numberOfRepeats.value}",
                        color = Color.Gray,
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontFamily = InterFamily
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.help
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable(
                                onClick = {
                                    openAlertDialog.value = true
                                },
                                interactionSource = interactionSource,
                                indication = null
                            )
                            .size(20.dp)
                        ,
                        tint = Color.Gray,
                    )
                }
            }
            Row(
                modifier = Modifier.weight(0.35f).fillMaxWidth().padding(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                if(wasSymbolRight.value){
                    Text(
                        text = "Верно",
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF03C03C),
                        fontFamily = InterFamily
                    )
                }
                if(wasSymbolWrong.value){
                    Text(text = "Неверно",
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFD05340),
                        fontFamily = InterFamily
                    )
                }
            }
            Row(
                modifier = Modifier.weight(2.5f).fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SymbolShow(
                    currentSymbol,
                    dot1,
                    dot2,
                    dot3,
                    dot4,
                    dot5,
                    dot6,
                    wasSymbolRight,
                    wasWrongButtonPush
                )
            }
            Column(modifier = Modifier
                .weight(1.5f)
                .padding(start = 8.dp, end = 8.dp, bottom = 32.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth().weight(1f)
                ) {
                    RightButton(
                        wasSymbolRight,
                        wasSymbolWrong,
                        wasWrongButtonPush,
                        dot1,
                        dot2,
                        dot3,
                        dot4,
                        dot5,
                        dot6,
                        currentSymbol,
                        repeatVM
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f).fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            if (!wasWrongButtonPush.value && !wasSymbolRight.value) {
                                dot1.value = currentSymbol.value.dot1
                                dot2.value = currentSymbol.value.dot2
                                dot3.value = currentSymbol.value.dot3
                                dot4.value = currentSymbol.value.dot4
                                dot5.value = currentSymbol.value.dot5
                                dot6.value = currentSymbol.value.dot6

                                wasWrongButtonPush.value = true
                                wasSymbolWrong.value = true
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorScheme.background,
                            contentColor = colorScheme.onBackground,
                            disabledContainerColor = colorScheme.background,
                            disabledContentColor = colorScheme.onBackground
                        ),
                        modifier = Modifier.weight(1f)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Icon(
                                painter = painterResource(
                                    id = R.drawable.close
                                ),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(24.dp)
                                    .width(24.dp)
                                    .padding(0.dp, 0.dp, 6.dp, 0.dp),
                                tint = colorScheme.onBackground
                            )
                            Text(
                                text = "Не помню",
                                fontFamily = InterFamily
                            )
                        }
                    }
                    Button(
                        onClick = {
                            dot1.value = false
                            dot2.value = false
                            dot3.value = false
                            dot4.value = false
                            dot5.value = false
                            dot6.value = false
                            wasWrongButtonPush.value = false
                            wasSymbolRight.value = false
                            wasSymbolWrong.value = false

                            repeatVM.nextSymbol()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorScheme.background,
                            contentColor = colorScheme.onBackground,
                            disabledContainerColor = colorScheme.background,
                            disabledContentColor = colorScheme.onBackground
                        ),
                        modifier = Modifier.weight(1f)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(text = "Следующий", fontFamily = InterFamily)
                            Icon(
                                painter = painterResource(
                                    id = R.drawable.arrow_forward
                                ),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(24.dp)
                                    .width(24.dp)
                                    .padding(4.dp, 0.dp, 0.dp, 0.dp),
                                tint = colorScheme.onBackground
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RightButton(
    wasSymbolRight: MutableState<Boolean>,
    wasSymbolWrong: MutableState<Boolean>,
    wasWrongButtonPush: MutableState<Boolean>,
    dot1: MutableState<Boolean>,
    dot2: MutableState<Boolean>,
    dot3: MutableState<Boolean>,
    dot4: MutableState<Boolean>,
    dot5: MutableState<Boolean>,
    dot6: MutableState<Boolean>,
    currentSymbol: MutableState<Symbol>,
    repeatVM: RepeatVM
){
    Button(
        onClick = {
            if (!wasSymbolRight.value &&  !wasWrongButtonPush.value &&
                dot1.value == currentSymbol.value.dot1 &&
                dot2.value == currentSymbol.value.dot2 &&
                dot3.value == currentSymbol.value.dot3 &&
                dot4.value == currentSymbol.value.dot4 &&
                dot5.value == currentSymbol.value.dot5 &&
                dot6.value == currentSymbol.value.dot6
            ) {
                repeatVM.updateRepeat()
                wasSymbolRight.value = true
                wasSymbolWrong.value = false
            } else if(!wasWrongButtonPush.value && !wasSymbolRight.value){
                wasSymbolWrong.value = true
            } }
    ) {
        Text(
            text = "Проверить",
            fontFamily = InterFamily
        )
    }
}