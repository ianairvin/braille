package ru.braille.presentation.dictionary_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.braille.domain.entities.Symbol
import ru.braille.domain.use_case.symbol_use_case.GetAllSymbolsUseCase
import ru.braille.domain.use_case.symbol_use_case.GetSymbolUseCase
import javax.inject.Inject

@HiltViewModel
class DictionaryVM @Inject constructor(
    private val getAllSymbolsUseCase: GetAllSymbolsUseCase,
    private val getSymbolUseCase: GetSymbolUseCase
) : ViewModel() {

    var allSymbols = emptyList<String>()
    var symbols = emptyList<List<String>>()
    var openSymbol = mutableStateOf<Symbol>(
        Symbol(
            "А",
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
        )
    )

    fun getAllSymbols() = viewModelScope.launch {
        allSymbols = getAllSymbolsUseCase()
        symbols = allSymbols.chunked(3)
    }

    fun getSymbol(symbol: String) = viewModelScope.launch {
        openSymbol.value = getSymbolUseCase(symbol)
    }

    init {
        getAllSymbols()
    }

}