package ru.braille.domain.use_case.statistics_use_case

import kotlinx.coroutines.flow.Flow
import ru.braille.domain.entities.SymbolStatistics
import ru.braille.domain.repository.StatisticsRepository
import javax.inject.Inject

class GetAllSymbolsStatisticsUseCase @Inject constructor(
    private val symbolStatisticsRepository: StatisticsRepository
) {
    operator fun invoke(): Flow<List<SymbolStatistics>> {
        return symbolStatisticsRepository.getAllSymbolsStatistics()
    }
}