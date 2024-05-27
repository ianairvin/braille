package ru.braille.domain.use_case.repeat_use_case

import ru.braille.domain.entities.Symbol
import ru.braille.domain.repository.RepeatRepository
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import javax.inject.Inject

class GetRepeatsSymbolsUseCase @Inject constructor(
    private val repeatRepository: RepeatRepository
) {
    suspend operator fun invoke(currentTime: LocalDateTime): List<Symbol> {
        return repeatRepository.getRepeatsSymbols(
            ZonedDateTime.of(
                currentTime,
                ZoneId.systemDefault()
            ).toInstant().toEpochMilli()
        )
    }
}