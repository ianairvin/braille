package ru.braille.presentation.main_elements_app

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import ru.braille.R


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopBar(
    navController: NavHostController,
    selectedItem: MutableState<String>,
    badgeCountLearning: MutableState<Int>
){
    val tabIndex = remember { mutableStateOf(0) }
    val pagerState = rememberPagerState( )
    val coroutineScope = rememberCoroutineScope()
    /*
    LaunchedEffect(pagerState.currentPage){
        tabIndex.value = pagerState.currentPage
    }*/
    Column() {
        Spacer(modifier = Modifier.padding(bottom = 16.dp))
        TabRow(
            selectedTabIndex = tabIndex.value
        ) {
            Tab(
                selected = pagerState.currentPage == 0,
                onClick = {
                    tabIndex.value = 0
                    coroutineScope.launch {pagerState.scrollToPage(tabIndex.value)}
                    selectedItem.value = "list_lessons"
                    navController.navigate("list_lessons") {
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                    }
                },
                text = { Text("Уроки") }
            )
            Tab(
                selected = pagerState.currentPage == 1,
                onClick = {
                    tabIndex.value = 1
                    coroutineScope.launch { pagerState.scrollToPage(tabIndex.value) }
                    selectedItem.value = "repeat"
                    navController.navigate("repeat") {
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                    }
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text("Повторение")
                        Spacer(modifier = Modifier.padding(end = 4.dp))
                        if (badgeCountLearning.value != 0) {
                            Icon(
                                painter = painterResource(id = R.drawable.circle),
                                contentDescription = null,
                                tint = colorScheme.error
                            )
                        }
                    }
               },
            )
        }

        /*HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            pageCount = 2
        ) {index ->
            if (tabIndex.value == index) {
                selectedItem.value = "list_lessons"
                navController.navigate("list_lessons") {
                    popUpTo(navController.graph.id) {
                        inclusive = true
                    }
                }
            } else {
                selectedItem.value = "repeat"
                navController.navigate("repeat") {
                    popUpTo(navController.graph.id) {
                        inclusive = true
                    }
                }
            }
        }*/
    }
}
