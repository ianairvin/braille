package ru.braille.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.braille.data.room.entities.LessonDB

@Database(
    entities = [LessonDB::class],
    version = 1
)

abstract class DataBase : RoomDatabase() {
    abstract val dao: Dao
    companion object {
        const val DB_NAME = "braille_app_db"
    }
}