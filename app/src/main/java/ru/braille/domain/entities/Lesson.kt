package ru.braille.domain.entities

data class Lesson(
    val number: Int,
    val symbol1: Char?,
    val symbol2: Char?,
    val symbol3: Char?,
    var completed: Boolean
)