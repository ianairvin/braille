package ru.braille.data.room

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.braille.data.room.entities.LessonDB
import ru.braille.data.room.entities.SymbolDB
import ru.braille.data.room.entities.SymbolRepeatDB
import ru.braille.data.room.entities.SymbolStatisticsDB

@Dao
interface Dao {
    @Query("SELECT * FROM lesson_table ORDER BY number")
    fun getListLessons(): Flow<List<LessonDB>>

    @Update
    suspend fun updateLesson(lesson: LessonDB)

    @Query("SELECT completed FROM lesson_table WHERE number = :numberOfLesson")
    suspend fun statusCompleteLesson(numberOfLesson: Int): Int

    @Query("SELECT * FROM symbol_table WHERE symbol = :symbol")
    suspend fun getSymbol(symbol: String): SymbolDB

    @Query("SELECT * FROM symbol_table WHERE numberOfLesson = :numberOfLesson")
    suspend fun getSymbolsOfLesson(numberOfLesson: Int): List<SymbolDB>

    @Query("SELECT symbol FROM symbol_table")
    suspend fun getAllSymbols(): List<String>

    @Query("SELECT * FROM symbol_table WHERE completed = 1")
    suspend fun getAllLearnedSymbols(): List<SymbolDB>

    @Query("SELECT * FROM symbol_statistics_table WHERE symbol = :symbol")
    suspend fun getSymbolStatistics(symbol: String): SymbolStatisticsDB

    @Query("SELECT * FROM symbol_statistics_table")
    fun getAllSymbolStatistics(): Flow<List<SymbolStatisticsDB>>

    @Query("UPDATE symbol_statistics_table SET `right` = :right, `wrong` = :wrong WHERE symbol = :symbol")
    suspend fun updateSymbolStatistics(symbol: String, right: Int, wrong: Int)

    @Update
    suspend fun updateSymbol(symbol: SymbolDB)

    @Query(
        "SELECT * FROM symbol_table LEFT JOIN symbol_repeat_table " +
                "ON symbol_table.symbol = symbol_repeat_table.symbol " +
                "WHERE (symbol_repeat_table.nextRepeat < :currentTime " +
                "AND symbol_repeat_table.isRepeated = 1)"
    )
    suspend fun getRepeatsSymbols(currentTime: Long): List<SymbolDB>

    @Query("SELECT numberOfRepeats FROM symbol_repeat_table WHERE symbol = :symbol")
    suspend fun getNumberOfRepeats(symbol: String): Int

    @Update
    suspend fun updateRepeat(repeat: SymbolRepeatDB)
}