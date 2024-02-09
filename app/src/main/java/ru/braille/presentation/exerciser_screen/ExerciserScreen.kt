package ru.braille.presentation.exerciser_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.braille.ui.theme.InterFamily

@Composable
fun ExerciserScreen(navController: NavController, exerciserVM: ExerciserVM) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(start = 32.dp, end = 32.dp, top = 32.dp, bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        if(exerciserVM.listLearnedSymbols.value.isEmpty()){
            Text(
                text = "Нет изученных символов",
                fontFamily = InterFamily,
                color = Color.Gray)
        } else {
            Statistics(navController)
            SurfaceSymbol(
                exerciserVM.currentSymbol,
                exerciserVM.currentSymbolStatistics,
                exerciserVM.dot1,
                exerciserVM.dot2,
                exerciserVM.dot3,
                exerciserVM.dot4,
                exerciserVM.dot5,
                exerciserVM.dot6,
                exerciserVM,
                exerciserVM.wasWrongButtonPush,
                exerciserVM.wasSymbolRight,
                exerciserVM.wasSymbolWrong
            )
        }
    }
}

@Composable
fun Statistics(navController: NavController){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Button(
            onClick = {
                navController.navigate("statistics") {
                }},
            colors = ButtonDefaults.buttonColors(
                containerColor = colorScheme.background,
                contentColor = colorScheme.onBackground,
                disabledContainerColor = colorScheme.background,
                disabledContentColor = colorScheme.onBackground
            ),
            contentPadding = PaddingValues(2.dp)
        ) {
            Text(text = "Статистика",
                fontFamily = InterFamily
            )
        }
    }
}