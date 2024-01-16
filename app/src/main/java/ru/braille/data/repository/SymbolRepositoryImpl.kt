package ru.braille.data.repository

import ru.braille.data.room.Dao
import ru.braille.data.room.entities.SymbolDB
import ru.braille.domain.entities.Symbol
import ru.braille.domain.repository.SymbolRepository
import javax.inject.Inject

class SymbolRepositoryImpl @Inject constructor(
    private val dao: Dao
) : SymbolRepository {
    override suspend fun getSymbol(findSymbol: String): Symbol {
        val symbolDB = dao.getSymbol(findSymbol)
        val symbol = Symbol(
            symbolDB.symbol,
            symbolDB.numberOfLesson,
            symbolDB.completed,
            symbolDB.dot1,
            symbolDB.dot2,
            symbolDB.dot3,
            symbolDB.dot4,
            symbolDB.dot5,
            symbolDB.dot6
        )
        return symbol
    }

    override suspend fun getSymbolsOfLesson(numberOfLesson: Int): List<Symbol> {
        val symbolsDB = dao.getSymbolsOfLesson(numberOfLesson)
        val symbols = arrayListOf<Symbol>()
        symbolsDB.forEach{
            val item = Symbol(
                it.symbol,
                it.numberOfLesson,
                it.completed,
                it.dot1,
                it.dot2,
                it.dot3,
                it.dot4,
                it.dot5,
                it.dot6
            )
            symbols.add(item)
        }
        return symbols
    }
}