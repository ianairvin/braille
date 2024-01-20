package ru.braille.domain.use_case.symbol_use_case

import ru.braille.domain.repository.SymbolRepository
import javax.inject.Inject

class GetAllSymbolsUseCase @Inject constructor(
    private val symbolRepository: SymbolRepository
) {
    suspend operator fun invoke() : List<String>{
        var list = symbolRepository.getAllSymbols().toMutableList()
        list.sort()
        list.set(0, "Е")
        list.sort()
        list.set(list.indexOf("Е") + 1, "Ё")
        return list
    }
}