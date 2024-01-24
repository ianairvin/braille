package ru.braille.domain.repository

import ru.braille.domain.entities.SymbolStatistics

interface StatisticsRepository {
    suspend fun updateSymbolStatistics(symbol: SymbolStatistics)
    suspend fun getSymbolStatistics(symbol: String) : SymbolStatistics

    suspend fun getAllSymbolsStatistics() : List<SymbolStatistics>
}