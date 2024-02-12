package ru.braille.domain.repository

import ru.braille.domain.entities.Symbol
import ru.braille.domain.entities.SymbolRepeat

interface RepeatRepository {
    suspend fun getRepeatsSymbols(currentTime: Long): List<Symbol>
    suspend fun updateRepeatSymbol(symbolRepeat: SymbolRepeat)
    suspend fun getNumberOfRepeats(symbol: String): Int
}