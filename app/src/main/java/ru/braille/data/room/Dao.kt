package ru.braille.data.room

import androidx.room.Dao
import androidx.room.Query
import ru.braille.data.room.entities.LessonDB
import ru.braille.data.room.entities.SymbolDB

@Dao
interface Dao {
    @Query ("SELECT * FROM lesson ORDER BY number")
    suspend fun getListLessons() : List<LessonDB>

    @Query ("SELECT * FROM symbol WHERE symbol = :symbol")
    suspend fun getSymbol(symbol: String) : SymbolDB

    @Query ("SELECT * FROM symbol WHERE symbol = :numberOfLesson")
    suspend fun getSymbolsOfLesson(numberOfLesson: Int) : List<SymbolDB>
}