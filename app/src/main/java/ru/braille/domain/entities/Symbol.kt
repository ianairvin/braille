package ru.braille.domain.entities

data class Symbol (
    var symbol: String,
    val numberOfLesson: Int,
    var completed: Boolean,
    val dot1: Boolean,
    val dot2: Boolean,
    val dot3: Boolean,
    val dot4: Boolean,
    val dot5: Boolean,
    val dot6: Boolean
)