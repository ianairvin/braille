package ru.braille.domain.use_case.symbol_use_case

import android.util.Log
import ru.braille.domain.entities.Symbol
import ru.braille.domain.repository.SymbolRepository
import javax.inject.Inject

class GetSymbolsOfLessonUseCase @Inject constructor (
    private val symbolRepository: SymbolRepository
){
    suspend operator fun invoke(numberOfLesson: Int) : List<Symbol> {
        var list = symbolRepository.getSymbolsOfLesson(numberOfLesson).toMutableList()
        list.sortBy { it.symbol }
        list[0].symbol = "Е"
        list.sortBy{ it.symbol }
        list.set(list.indexOf(
            Symbol("Е", 2, false,
            true, false, false, true, false, false))
                + 1,
            Symbol("Ё", 3, false,
            true, false, false, false, false, true))
        return list

    }
}