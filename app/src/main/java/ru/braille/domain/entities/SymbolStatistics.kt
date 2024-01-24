package ru.braille.domain.entities

data class SymbolStatistics(
    val symbol: String,
    var right: Int,
    var skip: Int,
    var wrong: Int
)
