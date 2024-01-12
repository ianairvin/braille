package ru.braille.data.room

import androidx.room.Dao
import androidx.room.Query
import ru.braille.data.room.entities.LessonDB

@Dao
interface Dao {
    @Query ("SELECT * FROM list_lessons ORDER BY number")
    suspend fun getListLessons() : List<LessonDB>
}