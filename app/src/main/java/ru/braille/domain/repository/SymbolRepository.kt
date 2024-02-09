package ru.braille.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.braille.domain.entities.Symbol

interface SymbolRepository {
    suspend fun getSymbol(findSymbol: String) : Symbol
    suspend fun getSymbolsOfLesson(findSymbols: Int) : List<Symbol>
    suspend fun getAllSymbols() : List<String>
    suspend fun getAllLearnedSymbols() : List<Symbol>
    suspend fun updateSymbol(symbol: Symbol)
}