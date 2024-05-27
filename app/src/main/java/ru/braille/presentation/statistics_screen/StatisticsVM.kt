package ru.braille.presentation.statistics_screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.braille.domain.use_case.statistics_use_case.GetAllSymbolsStatisticsUseCase
import javax.inject.Inject


@HiltViewModel
class StatisticsVM @Inject constructor(
    private val getAllSymbolsStatistics: GetAllSymbolsStatisticsUseCase
) : ViewModel() {
    var listStatistics = getAllSymbolsStatistics()
}