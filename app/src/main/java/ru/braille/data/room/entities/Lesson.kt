package ru.braille.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lessons")
data class Lesson(
    @PrimaryKey val number: Int,
    val symbol1: Char,
    val symbol2: Char?,
    val symbol3: Char?,
    var completed: Boolean
)
