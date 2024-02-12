package ru.braille.data.repository

import android.util.Log
import ru.braille.data.room.Dao
import ru.braille.domain.entities.Symbol
import ru.braille.domain.entities.SymbolRepeat
import ru.braille.domain.repository.RepeatRepository
import ru.braille.toSymbol
import ru.braille.toSymbolRepeatDB
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import javax.inject.Inject

class RepeatRepositoryImpl @Inject constructor(
    private val dao: Dao
) : RepeatRepository {

    override suspend fun getRepeatsSymbols(currentTime: Long): List<Symbol> {
        val listDB = dao.getRepeatsSymbols(currentTime)
        val list = mutableListOf<Symbol>()
        listDB.forEach{
            list.add(it.toSymbol())
        }
        return list
    }

    override suspend fun updateRepeatSymbol(symbolRepeat: SymbolRepeat) {
        dao.updateRepeat(symbolRepeat.toSymbolRepeatDB())
    }

    override suspend fun getNumberOfRepeats(symbol: String): Int {
        return dao.getNumberOfRepeats(symbol)
    }

}