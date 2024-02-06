package ru.braille.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.braille.data.room.Dao
import ru.braille.data.room.entities.SymbolStatisticsDB
import ru.braille.domain.entities.SymbolStatistics
import ru.braille.domain.repository.StatisticsRepository
import javax.inject.Inject

class StatisticsRepositoryImpl @Inject constructor(
    private val dao: Dao
): StatisticsRepository {
    override suspend fun updateSymbolStatistics(symbol: String, right: Int, wrong: Int) {
        dao.updateSymbolStatistics(symbol, right, wrong)
    }

    override suspend fun getSymbolStatistics(symbol: String): SymbolStatistics {
        val symbolStatisticsDB = dao.getSymbolStatistics(symbol)
        return SymbolStatistics(
            symbolStatisticsDB.symbol,
            symbolStatisticsDB.right,
            symbolStatisticsDB.wrong
        )
    }

    override fun getAllSymbolsStatistics(): Flow<List<SymbolStatistics>> {
        val listDB = dao.getAllSymbolStatistics()
        val list : Flow<List<SymbolStatistics>> = listDB.map {
                listDB -> listDB.map {
                it -> SymbolStatistics(
                    it.symbol,
                    it.right,
                    it.wrong
                )
            }
        }
        return list
    }
}