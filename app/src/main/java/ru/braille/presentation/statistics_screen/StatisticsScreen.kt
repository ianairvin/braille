package ru.braille.presentation.statistics_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.braille.domain.entities.SymbolStatistics
import ru.braille.ui.theme.InterFamily

@Composable
fun StatisticsScreen(statisticsVM: StatisticsVM){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 48.dp, top = 32.dp, bottom = 16.dp, end = 48.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(text = "Символ",
                    color = colorScheme.secondary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = InterFamily
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(text = "Верно",
                    color = colorScheme.secondary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = InterFamily
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(text = "Неверно",
                    color = colorScheme.secondary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = InterFamily
                )
            }
        }
        Items(
            statisticsVM.listStatistics.collectAsState(initial = emptyList())
        )
    }
}

@Composable
fun Items(
    list: State<List<SymbolStatistics>>
){
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 32.dp, start = 32.dp, end = 32.dp)
    ) {
        itemsIndexed(list.value) { i, item ->
            HorizontalDivider(Modifier.fillMaxWidth(), thickness = 3.dp)
            RowCell(item.symbol, item.right, item.wrong)
        }
    }
}


@Composable
fun RowCell(
    symbol: String,
    right: Int,
    wrong: Int
){
    Row(
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp, bottom = 16.dp, end = 16.dp)
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
        ) {
            Text(text = symbol,
                color = colorScheme.secondary,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                fontFamily = InterFamily
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)

        ) {
            Text(text = right.toString(),
                fontSize = 16.sp,
                fontFamily = InterFamily
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
        ) {
            Text(text = wrong.toString(),
                fontSize = 16.sp,
                fontFamily = InterFamily
            )
        }
    }
}