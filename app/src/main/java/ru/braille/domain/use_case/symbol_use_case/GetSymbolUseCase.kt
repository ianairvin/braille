package ru.braille.domain.use_case.symbol_use_case

import ru.braille.domain.entities.Symbol
import ru.braille.domain.repository.SymbolRepository
import javax.inject.Inject

class GetSymbolUseCase @Inject constructor(
    private val symbolRepository: SymbolRepository
) {
    suspend operator fun invoke(findSymbol: String): Symbol {
        return symbolRepository.getSymbol(findSymbol)
    }
}