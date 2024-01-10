package ru.braille.presentation.list_lessons_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import ru.braille.presentation.main_elements_app.BottomBar
import ru.braille.presentation.main_elements_app.TopBar

@Composable
fun ListLessonsScreen(
    navController: NavHostController,
    selectedItem: MutableState<String>
    ) {
    //из базы данных
    var badgeCountLearning = remember { mutableStateOf(1) }
    Column {
        TopBar(navController, selectedItem, badgeCountLearning)
        //ListLessons()
        ListLessons()
    }
}

@Composable
fun ListLessons(){
   LazyColumn(
       userScrollEnabled = true,
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ){
        item{
            Button(
                onClick = {}
            ){
                Text("j")
            }
        }
       item{
           Button(
               onClick = {}
           ){
               Text("j")
           }
       }
       item{
           Button(
               onClick = {}
           ){
               Text("j")
           }
       }
       item{
           Button(
               onClick = {}
           ){
               Text("j")
           }
       }
       item{
           Button(
               onClick = {}
           ){
               Text("j")
           }
       }
       item{
           Button(
               onClick = {}
           ){
               Text("j")
           }
       }
       item{
           Button(
               onClick = {}
           ){
               Text("j")
           }
       }
       item{
           Button(
               onClick = {}
           ){
               Text("j")
           }
       }
       item{
           Button(
               onClick = {}
           ){
               Text("j")
           }
       }
   }
}

