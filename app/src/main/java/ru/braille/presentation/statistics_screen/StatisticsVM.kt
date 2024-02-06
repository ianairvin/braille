package ru.braille.presentation.statistics_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.braille.domain.entities.SymbolStatistics
import ru.braille.domain.use_case.statistics_use_case.GetAllSymbolsStatisticsUseCase
import javax.inject.Inject


@HiltViewModel
class StatisticsVM @Inject constructor(
    private val getAllSymbolsStatistics: GetAllSymbolsStatisticsUseCase
) : ViewModel() {
    var listStatistics = getAllSymbolsStatistics()
}