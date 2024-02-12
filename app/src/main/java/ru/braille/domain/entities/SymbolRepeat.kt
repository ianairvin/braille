package ru.braille.domain.entities

import java.time.LocalDateTime

data class SymbolRepeat (
    val symbol: String,
    var nextRepeat: LocalDateTime,
    var numberOfRepeats: Int,
    var isRepeated: Boolean
)