package ru.braille.domain.entities

data class Lesson(
    val number: Int,
    val symbol1: String,
    val symbol2: String?,
    val symbol3: String?,
    var completed: Boolean
)