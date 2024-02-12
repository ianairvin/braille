package ru.braille.presentation.repeat_screen

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.braille.domain.entities.Symbol
import ru.braille.domain.use_case.repeat_use_case.GetNumberOfRepeatsUseCase
import ru.braille.domain.use_case.repeat_use_case.GetRepeatsSymbolsUseCase
import ru.braille.domain.use_case.repeat_use_case.UpdateRepeatSymbolUseCase
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class RepeatVM @Inject constructor(
    private val getRepeatsSymbols: GetRepeatsSymbolsUseCase,
    private val getNumberOfRepeats: GetNumberOfRepeatsUseCase,
    private val updateRepeatSymbol: UpdateRepeatSymbolUseCase
): ViewModel() {

    val repeatsSymbols = mutableStateOf<MutableList<Symbol>>(mutableListOf())
    val noSymbols = mutableStateOf(false)
    val numberOfRepeats = mutableStateOf(0)

    val currentSymbol = mutableStateOf(Symbol(
        "",
        0,
        false,
        false,
        false,
        false,
        false,
        false,
        false))


    var dot1 = mutableStateOf(false)
    var dot2 = mutableStateOf(false)
    var dot3 = mutableStateOf(false)
    var dot4 = mutableStateOf(false)
    var dot5 = mutableStateOf(false)
    var dot6 = mutableStateOf(false)

    val wasWrongButtonPush =  mutableStateOf(false)
    val wasSymbolRight =  mutableStateOf(false)
    val wasSymbolWrong = mutableStateOf(false)

    private fun getNumberOfRepeats() = viewModelScope.launch{
        numberOfRepeats.value = getNumberOfRepeats(currentSymbol.value.symbol)
    }

    fun nextSymbol(){
        val symbol = currentSymbol.value
        if(repeatsSymbols.value.size > 1){
            while (currentSymbol.value == symbol) {
                currentSymbol.value = repeatsSymbols.value.random()
            }
            getNumberOfRepeats()
        } else if(repeatsSymbols.value.size == 0){
            noSymbols.value = true
        } else {
            currentSymbol.value = repeatsSymbols.value.first()
            getNumberOfRepeats()
        }
    }

    /*
    private val handler = Handler(Looper.getMainLooper())
    private fun updateCurrentTime() {
        handler.postDelayed({
            updateListRepeatSymbols(LocalDateTime.now())
            updateCurrentTime()
        }, 2000)
    }
    */

    private fun updateListRepeatSymbols(currentTime: LocalDateTime) = viewModelScope.launch {
        repeatsSymbols.value = getRepeatsSymbols(currentTime).toMutableList()
        if(repeatsSymbols.value.isEmpty()){
            noSymbols.value = true
        }
        nextSymbol()
    }

    fun updateRepeat() = viewModelScope.launch {
        updateRepeatSymbol(currentSymbol.value.symbol, numberOfRepeats.value, false)
    }

    init{
        updateListRepeatSymbols(LocalDateTime.now())
        //updateCurrentTime()
    }
}