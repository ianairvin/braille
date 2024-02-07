package ru.braille.presentation.lesson_screen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import ru.braille.domain.entities.Symbol
import ru.braille.domain.use_case.symbol_use_case.GetSymbolUseCase
import ru.braille.domain.use_case.symbol_use_case.GetSymbolsOfLessonUseCase
import ru.braille.domain.use_case.symbol_use_case.UpdateSymbolUseCase
import javax.inject.Inject

@HiltViewModel
class LessonVM @Inject constructor(
    private val getSymbols: GetSymbolsOfLessonUseCase,
    private val updateSymbol: UpdateSymbolUseCase
): ViewModel() {
    var symbolsLesson: MutableState<List<Symbol>> = mutableStateOf(emptyList())
    val symbolsAreNotLearning: MutableState<MutableList<Symbol>> = mutableStateOf(mutableListOf())

    val selectedLesson = mutableStateOf(1)

    val currentSymbol = mutableStateOf(Symbol(
        "",
        0,
        false,
        false,
        false,
        false,
        false,
        false,
        false))

    var dot1 = mutableStateOf(false)
    var dot2 = mutableStateOf(false)
    var dot3 = mutableStateOf(false)
    var dot4 = mutableStateOf(false)
    var dot5 = mutableStateOf(false)
    var dot6 = mutableStateOf(false)

    val wasWrongButtonPush =  mutableStateOf(false)
    val wasSymbolRight =  mutableStateOf(false)
    val wasSymbolWrong = mutableStateOf(false)

    fun getSymbols() = viewModelScope.launch(){
        symbolsLesson.value = getSymbols(selectedLesson.value)
        symbolsAreNotLearning.value = symbolsLesson.value.toMutableList()
    }

    fun getOneSymbol() {
        val symbol = currentSymbol.value
        if (symbolsAreNotLearning.value.size != 1) {
            while (currentSymbol.value == symbol) {
                currentSymbol.value = symbolsAreNotLearning.value.random()
            }
        }
    }

    fun updateLearningSymbol() = viewModelScope.launch{
        currentSymbol.value.completed = true
        updateSymbol(currentSymbol.value)
    }

    init{
        getSymbols()
    }

}