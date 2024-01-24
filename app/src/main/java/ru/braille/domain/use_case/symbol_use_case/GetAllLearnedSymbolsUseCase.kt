package ru.braille.domain.use_case.symbol_use_case

import kotlinx.coroutines.flow.Flow
import ru.braille.domain.entities.Symbol
import ru.braille.domain.repository.SymbolRepository
import javax.inject.Inject

class GetAllLearnedSymbolsUseCase @Inject constructor(
    private val symbolRepository: SymbolRepository
) {
    operator fun invoke() : Flow<List<Symbol>> {
        return symbolRepository.getAllLearnedSymbols()
    }
}