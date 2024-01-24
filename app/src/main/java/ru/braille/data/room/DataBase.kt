package ru.braille.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.braille.data.room.entities.LessonDB
import ru.braille.data.room.entities.SymbolDB
import ru.braille.data.room.entities.SymbolStatisticsDB

@Database(
    entities = [LessonDB::class, SymbolDB::class, SymbolStatisticsDB::class],
    version = 1
)

abstract class DataBase : RoomDatabase() {
    abstract val dao: Dao
    companion object {
        const val DB_NAME = "braille_app_db"
    }
}