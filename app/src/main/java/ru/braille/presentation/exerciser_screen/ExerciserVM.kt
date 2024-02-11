package ru.braille.presentation.exerciser_screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.braille.domain.entities.Symbol
import ru.braille.domain.entities.SymbolStatistics
import ru.braille.domain.use_case.statistics_use_case.GetSymbolStatisticsUseCase
import ru.braille.domain.use_case.statistics_use_case.UpdateSymbolStatisticsUseCase
import ru.braille.domain.use_case.symbol_use_case.GetAllLearnedSymbolsUseCase
import javax.inject.Inject

@HiltViewModel
class ExerciserVM @Inject constructor(
    private val getAllLearnedSymbols: GetAllLearnedSymbolsUseCase,
    private val updateSymbolStatistics: UpdateSymbolStatisticsUseCase,
    private val getSymbolStatistics: GetSymbolStatisticsUseCase
) : ViewModel() {
    var listLearnedSymbols = mutableStateOf(emptyList<Symbol>())
    var currentSymbol = mutableStateOf(Symbol(
        "А", 1, true, false, false, false, false, false, false)
    )
    var currentSymbolStatistics = mutableStateOf(SymbolStatistics(
        "А", 0, 0)
    )

    val wasWrongButtonPush =  mutableStateOf(false)
    val wasSymbolRight =  mutableStateOf(false)
    val wasSymbolWrong = mutableStateOf(false)

    fun getFirstSymbol() = viewModelScope.launch{
        listLearnedSymbols.value = getAllLearnedSymbols()
        if(listLearnedSymbols.value.isNotEmpty()){
            currentSymbol.value = listLearnedSymbols.value.random()
            findSymbolStatistics()
        }
    }

    fun getSymbol() = viewModelScope.launch{
        val symbol = currentSymbol.value.symbol
        if(listLearnedSymbols.value.size != 1) {
            while (currentSymbol.value.symbol == symbol) {
                currentSymbol.value = listLearnedSymbols.value.random()
            }
            findSymbolStatistics()
        }
    }
    fun findSymbolStatistics() = viewModelScope.launch {
        currentSymbolStatistics.value = getSymbolStatistics(currentSymbol.value.symbol)
    }
    fun updateStatiscticsSymbol() = viewModelScope.launch {
        updateSymbolStatistics(
            currentSymbolStatistics.value.symbol,
            currentSymbolStatistics.value.right,
            currentSymbolStatistics.value.wrong)
    }

    fun updateListExerciser() = viewModelScope.launch {
        getFirstSymbol()
    }

    init{
        getFirstSymbol()
    }

    var dot1 = mutableStateOf(false)
    var dot2 = mutableStateOf(false)
    var dot3 = mutableStateOf(false)
    var dot4 = mutableStateOf(false)
    var dot5 = mutableStateOf(false)
    var dot6 = mutableStateOf(false)
}