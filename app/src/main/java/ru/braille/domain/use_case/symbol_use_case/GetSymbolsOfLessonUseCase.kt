package ru.braille.domain.use_case.symbol_use_case

import ru.braille.domain.entities.Symbol
import ru.braille.domain.repository.SymbolRepository
import javax.inject.Inject

class GetSymbolsOfLessonUseCase @Inject constructor(
    private val symbolRepository: SymbolRepository
) {
    suspend operator fun invoke(numberOfLesson: Int): List<Symbol> {
        return symbolRepository.getSymbolsOfLesson(numberOfLesson).toMutableList()
    }
}