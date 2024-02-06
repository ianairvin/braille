package ru.braille.domain.use_case.statistics_use_case

import ru.braille.domain.entities.SymbolStatistics
import ru.braille.domain.repository.StatisticsRepository
import javax.inject.Inject

class UpdateSymbolStatisticsUseCase @Inject constructor(
    private val statisticsRepository: StatisticsRepository
) {
    suspend operator fun invoke(symbol: String, right: Int, wrong: Int){
        statisticsRepository.updateSymbolStatistics(symbol, right, wrong)
    }
}