package ru.braille.domain.use_case.repeat_use_case

import ru.braille.domain.repository.RepeatRepository
import javax.inject.Inject

class GetNumberOfRepeatsUseCase @Inject constructor(
    private val repeatRepository: RepeatRepository
) {
    suspend operator fun invoke(symbol: String): Int {
        return repeatRepository.getNumberOfRepeats(symbol)
    }
}