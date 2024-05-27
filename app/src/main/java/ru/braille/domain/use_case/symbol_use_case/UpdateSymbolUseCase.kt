package ru.braille.domain.use_case.symbol_use_case

import ru.braille.domain.entities.Symbol
import ru.braille.domain.repository.SymbolRepository
import javax.inject.Inject


class UpdateSymbolUseCase @Inject constructor(
    val symbolRepository: SymbolRepository
) {
    suspend operator fun invoke(symbol: Symbol) {
        symbolRepository.updateSymbol(symbol)
    }
}