package ru.braille.presentation.lesson_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.braille.domain.entities.Symbol
import ru.braille.domain.use_case.symbol_use_case.GetSymbolUseCase
import ru.braille.domain.use_case.symbol_use_case.GetSymbolsOfLessonUseCase
import javax.inject.Inject

@HiltViewModel
class LessonVM @Inject constructor(
    private val getSymbolUseCase: GetSymbolUseCase,
    private val getSymbolsOfLessonUseCase: GetSymbolsOfLessonUseCase
): ViewModel() {
    lateinit var symbols: MutableState<List<Symbol>>
    val numberOfLesson = mutableStateOf(0)

    fun getSymbols() = viewModelScope.launch{
            symbols.value = getSymbolsOfLessonUseCase(numberOfLesson.value)
        }

}