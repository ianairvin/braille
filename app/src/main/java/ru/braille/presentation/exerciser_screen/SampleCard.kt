package ru.braille.presentation.exerciser_screen

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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.braille.R
import ru.braille.domain.entities.Symbol
import ru.braille.domain.entities.SymbolStatistics
import ru.braille.ui.theme.InterFamily

val interactionSource = MutableInteractionSource()

@Composable
fun SurfaceSymbol(
    currentSymbol: MutableState<Symbol>,
    currentStatisticsSymbol: MutableState<SymbolStatistics>,
    dot1: MutableState<Boolean>,
    dot2: MutableState<Boolean>,
    dot3: MutableState<Boolean>,
    dot4: MutableState<Boolean>,
    dot5: MutableState<Boolean>,
    dot6: MutableState<Boolean>,
    exerciserVM: ExerciserVM,
    wasWrongButtonPush: MutableState<Boolean>,
    wasSymbolRight: MutableState<Boolean>,
    wasSymbolWrong: MutableState<Boolean>
) {
    Column() {
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
                        .weight(1f)
                ) {}
                Row(
                    modifier = Modifier.weight(0.35f).fillMaxWidth().padding(top = 16.dp),
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
                            fontFamily = InterFamily,
                            color = Color(0xFFD05340))
                    }
                }
                Row(
                    modifier = Modifier.weight(3f).fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Symbol(
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
                    .weight(2f)
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
                            currentStatisticsSymbol,
                            exerciserVM
                        )
                    }
                    Spacer(Modifier.weight(0.25f))
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

                                    currentStatisticsSymbol.value.wrong += 1
                                    exerciserVM.updateStatiscticsSymbol()
                                    wasWrongButtonPush.value = true
                                    wasSymbolWrong.value = true
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.background,
                                contentColor = MaterialTheme.colorScheme.onBackground,
                                disabledContainerColor = MaterialTheme.colorScheme.background,
                                disabledContentColor = MaterialTheme.colorScheme.onBackground
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
                                    tint = MaterialTheme.colorScheme.onBackground
                                )
                                Text(
                                    text = "Не помню",
                                    fontFamily = InterFamily,
                                    fontSize = 12.sp
                                )
                            }
                        }
                        Button(
                            onClick = {
                                if(wasSymbolWrong.value) {
                                    exerciserVM.updateStatiscticsSymbol()
                                }
                                exerciserVM.getSymbol()
                                dot1.value = false
                                dot2.value = false
                                dot3.value = false
                                dot4.value = false
                                dot5.value = false
                                dot6.value = false
                                wasWrongButtonPush.value = false
                                wasSymbolRight.value = false
                                wasSymbolWrong.value = false
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.background,
                                contentColor = MaterialTheme.colorScheme.onBackground,
                                disabledContainerColor = MaterialTheme.colorScheme.background,
                                disabledContentColor = MaterialTheme.colorScheme.onBackground
                            ),
                            modifier = Modifier.weight(1f)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.End
                            ) {
                                Text(
                                    text = "Следующий",
                                    fontFamily = InterFamily,
                                    fontSize = 12.sp
                                )
                                Icon(
                                    painter = painterResource(
                                        id = R.drawable.arrow_forward
                                    ),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .height(16.dp)
                                        .width(16.dp)
                                        .padding(4.dp, 0.dp, 0.dp, 0.dp),
                                    tint = MaterialTheme.colorScheme.onBackground
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Symbol(
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
    currentStatisticsSymbol: MutableState<SymbolStatistics>,
    exerciserVM: ExerciserVM
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
                currentStatisticsSymbol.value.right += 1
                exerciserVM.updateStatiscticsSymbol()
                wasSymbolRight.value = true
                wasSymbolWrong.value = false
            } else if(!wasWrongButtonPush.value && !wasSymbolRight.value){
                currentStatisticsSymbol.value.wrong += 1
                exerciserVM.updateStatiscticsSymbol()
                wasSymbolWrong.value = true
            } },
    ) {
        Text(
            text = "Проверить",
            fontSize = 12.sp,
            fontFamily = InterFamily
        )
    }
}
