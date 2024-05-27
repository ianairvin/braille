package ru.braille.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "symbol_repeat_table")
data class SymbolRepeatDB(
    @PrimaryKey val symbol: String,
    var nextRepeat: Long,
    var numberOfRepeats: Int,
    var isRepeated: Int
)