package ru.braille.domain.repository

import ru.braille.domain.entities.Symbol

interface SymbolRepository {
    suspend fun getSymbol(findSymbol: String) : Symbol

    suspend fun getSymbolsOfLesson(findSymbols: Int) : List<Symbol>
}