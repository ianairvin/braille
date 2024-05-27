package ru.braille.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.braille.domain.entities.SymbolStatistics

interface StatisticsRepository {
    suspend fun updateSymbolStatistics(symbol: String, right: Int, wrong: Int)
    suspend fun getSymbolStatistics(symbol: String): SymbolStatistics
    fun getAllSymbolsStatistics(): Flow<List<SymbolStatistics>>
}