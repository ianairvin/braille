package ru.braille.data.room

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

class InitializeDB : RoomDatabase.Callback(){
    override fun onCreate(db: SupportSQLiteDatabase){
        super.onCreate(db)
        db.execSQL("INSERT INTO lessons (number, symbol1, symbol2, symbol3, completed)" +
        "values (1, А, Б, В, false)")
        db.execSQL("INSERT INTO lessons (number, symbol1, symbol2, symbol3, completed)" +
                "values (2, Г, Д, Е, false)")
        db.execSQL("INSERT INTO lessons (number, symbol1, symbol2, symbol3, completed)" +
                "values (3, Ё, Ж, З, false)")
        db.execSQL("INSERT INTO lessons (number, symbol1, symbol2, symbol3, completed)" +
                "values (4, И, Й, К, false)")
        db.execSQL("INSERT INTO lessons (number, symbol1, symbol2, symbol3, completed)" +
                "values (5, Л, М, Н, false)")
        db.execSQL("INSERT INTO lessons (number, symbol1, symbol2, symbol3, completed)" +
                "values (6, О, П, Р, false)")
        db.execSQL("INSERT INTO lessons (number, symbol1, symbol2, symbol3, completed)" +
                "values (7, С, Т, У, false)")
        db.execSQL("INSERT INTO lessons (number, symbol1, symbol2, symbol3, completed)" +
                "values (8, Ф, Х, Ц, false)")
        db.execSQL("INSERT INTO lessons (number, symbol1, symbol2, symbol3, completed)" +
                "values (9, Ч, Ш, Щ, false)")
        db.execSQL("INSERT INTO lessons (number, symbol1, symbol2, symbol3, completed)" +
                "values (10, Ъ, Ы, Ь, false)")
        db.execSQL("INSERT INTO lessons (number, symbol1, symbol2, symbol3, completed)" +
                "values (11, Э, Ю, Я, false)")
    }
}