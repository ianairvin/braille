package ru.braille.presentation.exerciser_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.braille.R
import ru.braille.domain.entities.Symbol

@Composable
fun ExerciserScreen(exerciserVM: ExerciserVM) {
    val interactionSource = MutableInteractionSource()

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(start = 32.dp, end = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorScheme.background,
                    contentColor = colorScheme.onBackground,
                    disabledContainerColor = colorScheme.background,
                    disabledContentColor = colorScheme.onBackground
                ),
                contentPadding = PaddingValues(2.dp)
            ){
                Text("Статистика")
            }
        }
        SurfaceSymbol(interactionSource)
    }
}

@Composable
fun SurfaceSymbol(
    interactionSource: MutableInteractionSource
) {
    Column() {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(580.dp),
            shape = MaterialTheme.shapes.large,
            tonalElevation = AlertDialogDefaults.TonalElevation
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(8.dp)
            ) {
                Row(
                    modifier = Modifier.weight(2f).fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Symbol()
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
                            onClick = { /*TODO*/ },
                           /* colors = ButtonDefaults.buttonColors(
                                containerColor = colorScheme.background,
                                contentColor = colorScheme.onBackground,
                                disabledContainerColor = colorScheme.background,
                                disabledContentColor = colorScheme.onBackground
                            ),*/
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
                            onClick = { /*TODO*/ },
                              colors = ButtonDefaults.buttonColors(
                                containerColor = colorScheme.background,
                                contentColor = colorScheme.onBackground,
                                disabledContainerColor = colorScheme.background,
                                disabledContentColor = colorScheme.onBackground
                            ),
                            //shape = ShapeDefaults.ExtraSmall,
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
                                    tint = colorScheme.onBackground
                                )
                                Text("Не помню")
                            }
                        }
                        Button(
                            onClick = { /*TODO*/ },
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
                                    tint = colorScheme.onBackground
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
fun Symbol(){//symbol: Symbol){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        Spacer(modifier = Modifier.weight(3f))
        Text(
            text = "A",
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
                    id = if (true)
                        R.drawable.fill_circle
                    else R.drawable.outline_circle
                ),
                contentDescription = null,
                modifier = Modifier
                    .height(54.dp)
                    .width(54.dp)
                    .padding(6.dp, 0.dp, 6.dp, 0.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Icon(
                painter = painterResource(
                    id = if (false)
                        R.drawable.fill_circle
                    else R.drawable.outline_circle
                ),
                contentDescription = null,
                modifier = Modifier
                    .height(54.dp)
                    .width(54.dp)
                    .padding(6.dp, 0.dp, 6.dp, 0.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(
                    id = if (true)
                        R.drawable.fill_circle
                    else R.drawable.outline_circle
                ),
                contentDescription = null,
                modifier = Modifier
                    .height(54.dp)
                    .width(54.dp)
                    .padding(6.dp, 0.dp, 6.dp, 0.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Icon(
                painter = painterResource(
                    id = if (false)
                        R.drawable.fill_circle
                    else R.drawable.outline_circle
                ),
                contentDescription = null,
                modifier = Modifier
                    .height(54.dp)
                    .width(54.dp)
                    .padding(6.dp, 0.dp, 6.dp, 0.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(
                    id = if (false)
                        R.drawable.fill_circle
                    else R.drawable.outline_circle
                ),
                contentDescription = null,
                modifier = Modifier
                    .height(54.dp)
                    .width(54.dp)
                    .padding(6.dp, 0.dp, 6.dp, 0.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Icon(
                painter = painterResource(
                    id = if (false)
                        R.drawable.fill_circle
                    else R.drawable.outline_circle
                ),
                contentDescription = null,
                modifier = Modifier
                    .height(54.dp)
                    .width(54.dp)
                    .padding(6.dp, 0.dp, 6.dp, 0.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Spacer(modifier = Modifier.weight(2f))
    }
}