package ru.braille.data.room

import androidx.room.Dao
import androidx.room.Query
import ru.braille.data.room.entities.LessonDB
import ru.braille.data.room.entities.SymbolDB

@Dao
interface Dao {
    @Query ("SELECT * FROM lesson_table ORDER BY number")
    suspend fun getListLessons() : List<LessonDB>

    @Query ("SELECT * FROM symbol_table WHERE symbol = :symbol")
    suspend fun getSymbol(symbol: String) : SymbolDB

    @Query ("SELECT * FROM symbol_table WHERE numberOfLesson = :numberOfLesson")
    suspend fun getSymbolsOfLesson(numberOfLesson: Int) : List<SymbolDB>

    @Query("SELECT symbol FROM symbol_table")
    suspend fun getAllSymbols() : List<String>
}