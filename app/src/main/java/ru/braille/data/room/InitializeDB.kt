package ru.braille.data.room

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

class InitializeDB : RoomDatabase.Callback(){
    override fun onCreate(db: SupportSQLiteDatabase){
        super.onCreate(db)

        initListLessons(db)
        initSymbol(db)
    }
}

fun initListLessons(db: SupportSQLiteDatabase){
    db.execSQL("INSERT INTO lesson (number, symbol1, symbol2, symbol3, completed)" +
            " values (1, 'А', 'Б', 'В', false)")
    db.execSQL("INSERT INTO lesson (number, symbol1, symbol2, symbol3, completed)" +
            " values (2, 'Г', 'Д', 'Е', false)")
    db.execSQL("INSERT INTO lesson (number, symbol1, symbol2, symbol3, completed)" +
            " values (3, 'Ё', 'Ж', 'З', false)")
    db.execSQL("INSERT INTO lesson (number, symbol1, symbol2, symbol3, completed)" +
            " values (4, 'И', 'Й', 'К', false)")
    db.execSQL("INSERT INTO lesson (number, symbol1, symbol2, symbol3, completed)" +
            " values (5, 'Л', 'М', 'Н', false)")
    db.execSQL("INSERT INTO lesson (number, symbol1, symbol2, symbol3, completed)" +
            " values (6, 'О', 'П', 'Р', false)")
    db.execSQL("INSERT INTO lesson (number, symbol1, symbol2, symbol3, completed)" +
            " values (7, 'С', 'Т', 'У', false)")
    db.execSQL("INSERT INTO lesson (number, symbol1, symbol2, symbol3, completed)" +
            " values (8, 'Ф', 'Х', 'Ц', false)")
    db.execSQL("INSERT INTO lesson (number, symbol1, symbol2, symbol3, completed)" +
            " values (9, 'Ч', 'Ш', 'Щ', false)")
    db.execSQL("INSERT INTO lesson (number, symbol1, symbol2, symbol3, completed)" +
            " values (10, 'Ъ', 'Ы', 'Ь', false)")
    db.execSQL("INSERT INTO lesson (number, symbol1, symbol2, symbol3, completed)" +
            " values (11, 'Э', 'Ю', 'Я', false)")
}

fun initSymbol(db: SupportSQLiteDatabase) {
    db.execSQL("INSERT INTO symbol (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('А', 1, false, true, false, false, false, false, false)")
}