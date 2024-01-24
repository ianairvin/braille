package ru.braille.data.room

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.braille.data.room.entities.LessonDB
import ru.braille.data.room.entities.SymbolDB
import ru.braille.data.room.entities.SymbolStatisticsDB

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

    @Query("SELECT * FROM symbol_table WHERE completed = 1")
    fun getAllLearnedSymbols() : Flow<List<SymbolDB>>

    @Query("SELECT * FROM symbol_statistics_table WHERE symbol = :symbol")
    suspend fun getSymbolStatistics(symbol: String) : SymbolStatisticsDB

    @Query("SELECT * FROM symbol_statistics_table")
    suspend fun getAllSymbolStatistics() : List<SymbolStatisticsDB>

    @Update
    suspend fun updateSymbolStatistics(statistics: SymbolStatisticsDB)
}