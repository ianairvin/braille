package ru.braille.domain.entities

data class SymbolStatistics(
    val symbol: String,
    var right: Int,
    var wrong: Int
)
