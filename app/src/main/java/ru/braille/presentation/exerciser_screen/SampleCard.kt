package ru.braille.presentation.exerciser_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.braille.R
import ru.braille.domain.entities.Symbol
import ru.braille.domain.entities.SymbolStatistics

val interactionSource = MutableInteractionSource()

@Composable
fun SurfaceSymbol(
    currentSymbol: MutableState<Symbol>,
    currentStatisticsSymbol: MutableState<SymbolStatistics>,
    listSymbols: State<List<Symbol>>,
    dot1: MutableState<Boolean>,
    dot2: MutableState<Boolean>,
    dot3: MutableState<Boolean>,
    dot4: MutableState<Boolean>,
    dot5: MutableState<Boolean>,
    dot6: MutableState<Boolean>,
    exerciserVM: ExerciserVM
) {
    Column() {
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(580.dp),
            shape = MaterialTheme.shapes.large
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(8.dp)
            ) {
                Row(
                    modifier = Modifier.weight(2f).fillMaxWidth(),
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
                        dot6
                    )
                }
                Column(modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp, end = 8.dp)
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth().weight(1f)
                    ) {
                        Button(
                            onClick = {
                                      if (dot1.value == currentSymbol.value.dot1
                                          && dot2.value == currentSymbol.value.dot2
                                          && dot3.value == currentSymbol.value.dot3
                                          && dot4.value == currentSymbol.value.dot4
                                          && dot5.value == currentSymbol.value.dot5
                                          && dot6.value == currentSymbol.value.dot6
                                      ) {
                                          currentStatisticsSymbol.value.right += 1
                                          exerciserVM.updateStatiscticsSymbol()

                                      } else {
                                          currentStatisticsSymbol.value.wrong += 1
                                          exerciserVM.updateStatiscticsSymbol()
                                      }
                                      },
                        ) {
                            Text(
                                text = "Проверить"
                            )
                        }
                    }


                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f).fillMaxWidth()
                    ) {
                        Button(
                            onClick = {
                                dot1.value = currentSymbol.value.dot1
                                dot2.value = currentSymbol.value.dot2
                                dot3.value = currentSymbol.value.dot3
                                dot4.value = currentSymbol.value.dot4
                                dot5.value = currentSymbol.value.dot5
                                dot6.value = currentSymbol.value.dot6

                                currentStatisticsSymbol.value.skip += 1
                                exerciserVM.updateStatiscticsSymbol()
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
                                        .padding(6.dp, 0.dp, 6.dp, 0.dp),
                                    tint = MaterialTheme.colorScheme.onBackground
                                )
                                Text("Не помню")
                            }
                        }
                        Button(
                            onClick = {
                                val symbol = currentSymbol.value
                                currentSymbol.value = listSymbols.value.random()
                                while(currentSymbol.value == symbol){
                                    currentSymbol.value = listSymbols.value.random()
                                }
                                dot1.value = false
                                dot2.value = false
                                dot3.value = false
                                dot4.value = false
                                dot5.value = false
                                dot6.value = false
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
                                Text("Следующий")
                                Icon(
                                    painter = painterResource(
                                        id = R.drawable.arrow_forward
                                    ),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .height(24.dp)
                                        .width(24.dp)
                                        .padding(6.dp, 0.dp, 6.dp, 0.dp),
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
    dot6: MutableState<Boolean>
    ){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        Spacer(modifier = Modifier.weight(3f))
        Text(
            text = currentSymbol.value.symbol,
            fontSize = 64.sp,
            fontWeight = FontWeight.Bold
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
                modifier = Modifier
                    .height(54.dp)
                    .width(54.dp)
                    .padding(6.dp, 0.dp, 6.dp, 0.dp)
                    .clickable (
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = {
                            dot1.value = !dot1.value
                        }),
                tint = MaterialTheme.colorScheme.primary
            )
            Icon(
                painter = painterResource(
                    id = if (dot2.value)
                        R.drawable.fill_circle
                    else R.drawable.outline_circle
                ),
                contentDescription = null,
                modifier = Modifier
                    .height(54.dp)
                    .width(54.dp)
                    .padding(6.dp, 0.dp, 6.dp, 0.dp)
                    .clickable (
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = {
                            dot2.value = !dot2.value
                        }),
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
                modifier = Modifier
                    .height(54.dp)
                    .width(54.dp)
                    .padding(6.dp, 0.dp, 6.dp, 0.dp)
                    .clickable (
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = {
                            dot3.value = !dot3.value
                        }),
                tint = MaterialTheme.colorScheme.primary
            )
            Icon(
                painter = painterResource(
                    id = if (dot4.value)
                        R.drawable.fill_circle
                    else R.drawable.outline_circle
                ),
                contentDescription = null,
                modifier = Modifier
                    .height(54.dp)
                    .width(54.dp)
                    .padding(6.dp, 0.dp, 6.dp, 0.dp)
                    .clickable (
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = {
                            dot4.value = !dot4.value
                        }),
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
                modifier = Modifier
                    .height(54.dp)
                    .width(54.dp)
                    .padding(6.dp, 0.dp, 6.dp, 0.dp)
                    .clickable (
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = {
                            dot5.value = !dot5.value
                        }),
                tint = MaterialTheme.colorScheme.primary
            )
            Icon(
                painter = painterResource(
                    id = if (dot6.value)
                        R.drawable.fill_circle
                    else R.drawable.outline_circle
                ),
                contentDescription = null,
                modifier = Modifier
                    .height(54.dp)
                    .width(54.dp)
                    .padding(6.dp, 0.dp, 6.dp, 0.dp)
                    .clickable (
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = {
                            dot6.value = !dot6.value
                        }),
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Spacer(modifier = Modifier.weight(2f))
    }
}