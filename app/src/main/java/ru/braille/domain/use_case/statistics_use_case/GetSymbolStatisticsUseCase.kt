package ru.braille.domain.use_case.statistics_use_case

import ru.braille.domain.entities.SymbolStatistics
import ru.braille.domain.repository.StatisticsRepository
import javax.inject.Inject

class GetSymbolStatisticsUseCase @Inject constructor(
    private val symbolStatisticsRepository: StatisticsRepository
) {
    suspend operator fun invoke(symbol: String): SymbolStatistics {
        return symbolStatisticsRepository.getSymbolStatistics(symbol)
    }
}