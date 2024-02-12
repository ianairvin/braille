package ru.braille.domain.use_case.repeat_use_case

import android.util.Log
import ru.braille.domain.entities.SymbolRepeat
import ru.braille.domain.repository.RepeatRepository
import java.time.LocalDateTime
import javax.inject.Inject

class UpdateRepeatSymbolUseCase @Inject constructor(
    private val repeatRepository: RepeatRepository
) {
    suspend operator fun invoke(symbol: String, numberOfRepeat: Int, reset: Boolean) {
        val repeat = when(numberOfRepeat){
            0 -> LocalDateTime.now()
            1 -> LocalDateTime.now().plusHours(1)
            2 -> LocalDateTime.now().plusHours(3)
            3 -> LocalDateTime.now().plusHours(8)
            4 -> LocalDateTime.now().plusDays(1)
            5 -> LocalDateTime.now().plusDays(2)
            6 -> LocalDateTime.now().plusDays(7)
            7 -> LocalDateTime.now().plusDays(14)
            else -> LocalDateTime.of(1970, 1, 1, 0, 0, 0)
        }

        val isRepeated = numberOfRepeat < 8 && !reset
        Log.i("www", isRepeated.toString())
        repeatRepository.updateRepeatSymbol(
            SymbolRepeat(
                symbol,
                repeat,
                numberOfRepeat + 1,
                isRepeated
            )
        )
    }
}