package ru.braille.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "symbol_statistics_table")
data class SymbolStatisticsDB(
    @PrimaryKey val symbol: String,
    var right: Int,
    var wrong: Int
)