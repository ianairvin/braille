package ru.braille.presentation.exerciser_screen

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
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
    var listLearnedSymbols = flowOf<List<Symbol>>()
    var currentSymbol = mutableStateOf(Symbol(
        "А", 1, true, false, false, false, false, false, false)
    )
    var currentSymbolStatistics = mutableStateOf(SymbolStatistics(
        "А", 0, 0, 0)
    )
    fun getSymbols() = viewModelScope.launch{
        listLearnedSymbols = getAllLearnedSymbols()
        currentSymbol.value = listLearnedSymbols.toList()[1].random()
        findSymbolStatistics()
    }
    fun findSymbolStatistics() = viewModelScope.launch {
        currentSymbolStatistics.value = getSymbolStatistics(currentSymbol.value.symbol)
    }
    fun updateStatiscticsSymbol() = viewModelScope.launch {
        updateSymbolStatistics(currentSymbolStatistics.value)
    }
    init{
        getSymbols()
    }

    var dot1 = mutableStateOf(false)
    var dot2 = mutableStateOf(false)
    var dot3 = mutableStateOf(false)
    var dot4 = mutableStateOf(false)
    var dot5 = mutableStateOf(false)
    var dot6 = mutableStateOf(false)
}