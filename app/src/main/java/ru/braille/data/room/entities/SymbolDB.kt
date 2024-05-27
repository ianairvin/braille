package ru.braille.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "symbol_table")
data class SymbolDB(
    @PrimaryKey val symbol: String,
    val numberOfLesson: Int,
    var completed: Int,
    val dot1: Int,
    val dot2: Int,
    val dot3: Int,
    val dot4: Int,
    val dot5: Int,
    val dot6: Int
)