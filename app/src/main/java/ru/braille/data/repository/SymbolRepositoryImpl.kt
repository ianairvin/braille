package ru.braille.data.repository

import ru.braille.data.room.Dao
import ru.braille.domain.entities.Symbol
import ru.braille.domain.repository.SymbolRepository
import ru.braille.toSymbol
import ru.braille.toSymbolDB
import javax.inject.Inject

class SymbolRepositoryImpl @Inject constructor(
    private val dao: Dao
) : SymbolRepository {
    override suspend fun getSymbol(findSymbol: String): Symbol {
        return dao.getSymbol(findSymbol).toSymbol()
    }

    override suspend fun getSymbolsOfLesson(numberOfLesson: Int): List<Symbol> {
        val symbolsDB = dao.getSymbolsOfLesson(numberOfLesson)
        val symbols = arrayListOf<Symbol>()
        symbolsDB.forEach{
            symbols.add(it.toSymbol())
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
            symbols.add(it.toSymbol())
        }
        return if (symbols.isEmpty()) emptyList() else symbols
    }

    override suspend fun updateSymbol(symbol: Symbol) {
        dao.updateSymbol(symbol.toSymbolDB())
    }

}