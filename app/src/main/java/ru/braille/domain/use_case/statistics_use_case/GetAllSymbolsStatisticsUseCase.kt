package ru.braille.domain.use_case.statistics_use_case

import ru.braille.data.room.initSymbolStatistics
import ru.braille.domain.entities.SymbolStatistics
import ru.braille.domain.repository.StatisticsRepository
import javax.inject.Inject

class GetAllSymbolsStatisticsUseCase @Inject constructor(
    private val symbolStatisticsRepository: StatisticsRepository
) {
    suspend operator fun invoke() : List<SymbolStatistics> {
        return symbolStatisticsRepository.getAllSymbolsStatistics()
    }
}