package ru.braille.presentation.lesson_screen

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
import ru.braille.presentation.main_elements_app.TopBar

@Composable
fun LessonScreen(
    navController: NavHostController,
    selectedItem: MutableState<String>,
    badgeCountLearning: MutableState<Int>,
    lessonVM: LessonVM,
    tabIndex: MutableState<Int>,
    selectedLesson: MutableState<Int>
) {
    lessonVM.numberOfLesson.value = selectedLesson.value
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(navController, selectedItem, badgeCountLearning, tabIndex)
        Lesson(lessonVM.symbols.value, selectedLesson)
    }
}

@Composable
fun Lesson(symbols: List<Symbol>, selectedLesson: MutableState<Int>) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.padding(top = 48.dp, bottom = 48.dp, start = 32.dp, end = 32.dp).fillMaxSize(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = colorScheme.surface
            )
        ) {
            val firstSymbol = symbols[0].symbol
            val secondSymbol = symbols[1].symbol
            val thirdSymbol = symbols[2].symbol
            Text(
                text = "Урок $selectedLesson\n буквы $firstSymbol, $secondSymbol и $thirdSymbol",
                color = colorScheme.surfaceVariant,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 8.dp, top = 6.dp)
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.weight(3f))
                Text(
                    text = "А",
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
                        tint = colorScheme.primary
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
                        tint = colorScheme.primary
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
                        tint = colorScheme.primary
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
                        tint = colorScheme.primary
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
                        tint = colorScheme.primary
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
                        tint = colorScheme.primary
                    )
                }
                Spacer(modifier = Modifier.weight(3f))
            }
        }
    }
}