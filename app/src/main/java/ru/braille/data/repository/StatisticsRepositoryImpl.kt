package ru.braille.data.repository

import ru.braille.data.room.Dao
import ru.braille.data.room.entities.SymbolStatisticsDB
import ru.braille.domain.entities.SymbolStatistics
import ru.braille.domain.repository.StatisticsRepository
import javax.inject.Inject

class StatisticsRepositoryImpl @Inject constructor(
    private val dao: Dao
): StatisticsRepository {
    override suspend fun updateSymbolStatistics(symbol: SymbolStatistics) {
        val symbolDB = SymbolStatisticsDB(
            symbol.symbol,
            symbol.right,
            symbol.skip,
            symbol.wrong
        )
        dao.updateSymbolStatistics(symbolDB)
    }

    override suspend fun getSymbolStatistics(symbol: String): SymbolStatistics {
        val symbolStatisticsDB = dao.getSymbolStatistics(symbol)
        return SymbolStatistics(
            symbolStatisticsDB.symbol,
            symbolStatisticsDB.right,
            symbolStatisticsDB.skip,
            symbolStatisticsDB.wrong
        )
    }

    override suspend fun getAllSymbolsStatistics(): List<SymbolStatistics> {
        val listDB = dao.getAllSymbolStatistics()
        val list = mutableListOf<SymbolStatistics>()
        listDB.forEach{
            list.add(SymbolStatistics(
                it.symbol,
                it.right,
                it.skip,
                it.wrong
            ))
        }
        return list
    }
}