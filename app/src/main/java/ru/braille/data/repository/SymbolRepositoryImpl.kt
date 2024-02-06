package ru.braille.data.repository

import android.util.Log
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
        return Symbol(
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

    override suspend fun getAllSymbols(): List<String> {
        return dao.getAllSymbols()
    }

    override suspend fun getAllLearnedSymbols() : List<Symbol>{
        val symbolsDB = dao.getAllLearnedSymbols()
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
        return if (symbols.isEmpty()) emptyList<Symbol>() else symbols
    }


}