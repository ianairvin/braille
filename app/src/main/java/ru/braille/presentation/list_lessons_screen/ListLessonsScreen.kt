package ru.braille.presentation.list_lessons_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ru.braille.domain.entities.Lesson
import ru.braille.presentation.main_elements_app.TopBar
import javax.inject.Inject

@Composable
fun ListLessonsScreen(
    navController: NavHostController,
    selectedItem: MutableState<String>,
    badgeCountLearning: MutableState<Int>,
    listLessonsVM: ListLessonsVM
){
    val tabIndex = remember { mutableStateOf(0) }
    val listLessons = listLessonsVM.listLessons
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(navController, selectedItem, badgeCountLearning, tabIndex)
        Column(modifier = Modifier.weight(8f)) {
            ListLessons(listLessons.value)
        }
    }
}


@Composable
fun ListLessons(listLessons : List<Lesson>){
   LazyColumn(
       userScrollEnabled = true,
       modifier = Modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ){
       itemsIndexed(listLessons) {_, item ->
           if(item.number == 1) {
               Spacer(modifier = Modifier.padding(12.dp))
           }
           if(item.completed) {
               Button(
                   onClick = {},
                   modifier = Modifier.width(280.dp)
               ) {
                   Text(
                       text = "Урок ${item.number}\nБуквы ${item.symbol1}, ${item.symbol2} и ${item.symbol3}",
                       textAlign = TextAlign.Center
                   )
               }
           } else {
               OutlinedButton(
                   onClick = {},
                   modifier = Modifier.width(280.dp)
               ) {
                   Text(
                       text = "Урок ${item.number}\nБуквы ${item.symbol1}, ${item.symbol2} и ${item.symbol3}",
                       textAlign = TextAlign.Center
                   )

               }
           }
           Spacer(modifier = Modifier.padding(12.dp))
       }
   }
}

