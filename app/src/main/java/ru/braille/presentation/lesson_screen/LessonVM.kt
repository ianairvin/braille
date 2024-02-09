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
import ru.braille.domain.entities.Lesson
import ru.braille.domain.entities.Symbol
import ru.braille.domain.use_case.lesson_use_case.StatusCompleteLessonUseCase
import ru.braille.domain.use_case.lesson_use_case.UpdateLessonUseCase
import ru.braille.domain.use_case.symbol_use_case.GetSymbolUseCase
import ru.braille.domain.use_case.symbol_use_case.GetSymbolsOfLessonUseCase
import ru.braille.domain.use_case.symbol_use_case.UpdateSymbolUseCase
import javax.inject.Inject

@HiltViewModel
class LessonVM @Inject constructor(
    private val getSymbols: GetSymbolsOfLessonUseCase,
    private val updateSymbol: UpdateSymbolUseCase,
    private val updateLesson: UpdateLessonUseCase,
    private val statusCompleteLesson: StatusCompleteLessonUseCase
): ViewModel() {
    var symbolsLesson: MutableState<List<Symbol>> = mutableStateOf(emptyList())
    val symbolsAreNotLearning: MutableState<MutableList<Symbol>> = mutableStateOf(mutableListOf())

    val selectedLesson = mutableStateOf(1)

    val wasLessonComplete = mutableStateOf(false)

    val noSymbols = mutableStateOf(false)

    val listFirstShow: MutableState<MutableList<Symbol>> = mutableStateOf(mutableListOf())
    val islistFirstShowEmpty = mutableStateOf(false)

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

    fun getSymbols() = viewModelScope.launch() {
        symbolsLesson.value = getSymbols(selectedLesson.value)
        symbolsAreNotLearning.value.clear()
        symbolsLesson.value.forEach {
            if(!it.completed) {
                symbolsAreNotLearning.value.add(it)
            }
        }
        if(symbolsAreNotLearning.value.isEmpty()) {
            noSymbols.value = true
        } else {
            currentSymbol.value = symbolsAreNotLearning.value.first()
            noSymbols.value = false
            symbolsAreNotLearning.value.forEach{
                listFirstShow.value.add(it)
            }
            firstSymbolForFirstShow()
        }
    }

    fun getOneSymbol() {
        val symbol = currentSymbol.value
        if (symbolsAreNotLearning.value.size != 1) {
            while (currentSymbol.value == symbol) {
                currentSymbol.value = symbolsAreNotLearning.value.random()
            }
        } else {
            currentSymbol.value = symbolsAreNotLearning.value.first()
        }
    }

    fun updateLearningSymbol() = viewModelScope.launch{
        currentSymbol.value.completed = !currentSymbol.value.completed
        updateSymbol(currentSymbol.value)
    }

    fun wasLessonComplete() = viewModelScope.launch{
        wasLessonComplete.value = statusCompleteLesson(selectedLesson.value)
    }

    fun updateLesson() = viewModelScope.launch{
        Log.i("qqqq",                 selectedLesson.value.toString())
        Log.i("qqqq",                 symbolsLesson.value[0].symbol.toString())
        Log.i("qqqq",                 symbolsLesson.value[1].symbol.toString())
        Log.i("qqqq",                 symbolsLesson.value[2].symbol.toString())
        Log.i("qqqq",                 wasLessonComplete.value.toString())
        updateLesson(
            Lesson(
                selectedLesson.value,
                symbolsLesson.value[0].symbol,
                symbolsLesson.value[1].symbol,
                symbolsLesson.value[2].symbol,
                wasLessonComplete.value
            )
        )
    }

    private fun firstSymbolForFirstShow(){
        islistFirstShowEmpty.value = false
        currentSymbol.value = listFirstShow.value.first()
        dot1.value = currentSymbol.value.dot1
        dot2.value = currentSymbol.value.dot2
        dot3.value = currentSymbol.value.dot3
        dot4.value = currentSymbol.value.dot4
        dot5.value = currentSymbol.value.dot5
        dot6.value = currentSymbol.value.dot6
        listFirstShow.value.remove(currentSymbol.value)
    }
    fun nextSymbolForFirstShow(){
        listFirstShow.value.remove(currentSymbol.value)
        if(listFirstShow.value.isNotEmpty()) {
            islistFirstShowEmpty.value = false
            currentSymbol.value = listFirstShow.value.first()
            dot1.value = currentSymbol.value.dot1
            dot2.value = currentSymbol.value.dot2
            dot3.value = currentSymbol.value.dot3
            dot4.value = currentSymbol.value.dot4
            dot5.value = currentSymbol.value.dot5
            dot6.value = currentSymbol.value.dot6
        } else {
            currentSymbol.value = symbolsAreNotLearning.value.first()
            dot1.value = false
            dot2.value = false
            dot3.value = false
            dot4.value = false
            dot5.value = false
            dot6.value = false
            islistFirstShowEmpty.value = true
        }
    }

    fun initFun() = viewModelScope.launch() {
        symbolsLesson.value = getSymbols(selectedLesson.value)
    }
    init{
        initFun()
    }

}