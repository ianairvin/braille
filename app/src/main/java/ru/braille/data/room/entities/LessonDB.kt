package ru.braille.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_lessons")
data class LessonDB(
    @PrimaryKey val number: Int,
    val symbol1: String,
    val symbol2: String?,
    val symbol3: String?,
    var completed: Boolean
)
