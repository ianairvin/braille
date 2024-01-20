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
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (1, 'А', 'Б', 'В', false)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (2, 'Г', 'Д', 'Е', false)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (3, 'Ё', 'Ж', 'З', false)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (4, 'И', 'Й', 'К', false)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (5, 'Л', 'М', 'Н', false)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (6, 'О', 'П', 'Р', false)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (7, 'С', 'Т', 'У', false)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (8, 'Ф', 'Х', 'Ц', false)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (9, 'Ч', 'Ш', 'Щ', false)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (10, 'Ъ', 'Ы', 'Ь', false)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (11, 'Э', 'Ю', 'Я', false)")
}

fun initSymbol(db: SupportSQLiteDatabase) {
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('А', 1, false, true, false, false, false, false, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Б', 1, false," +
            " true, false, true, false, false, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('В', 1, false," +
            " false, true, true, true, false, true)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Г', 2, false," +
            " true, true, true, true, false, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Д', 2, false," +
            " true, true, false, true, false, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Е', 2, false," +
            " true, false, false, true, false, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ё', 3, false," +
            " true, false, false, false, false, true)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ж', 3, false," +
            " false, true, true, true, false, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('З', 3, false," +
            " true, false, false, true, true, true)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('И', 4, false," +
            " false, true, true, false, false, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Й', 4, false," +
            " true, true, true, false, true, true)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('К', 4, false," +
            " true, false, false, false, true, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Л', 5, false," +
            " true, false, true, false, true, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('М', 5, false," +
            " true, true, false, false, true, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Н', 5, false," +
            " true, true, false, true, true, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('О', 6, false," +
            " true, false, false, true, true, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('П', 6, false," +
            " true, true, true, false, true, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Р', 6, false," +
            " true, false, true, true, true, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('С', 7, false," +
            " false, true, true, false, true, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Т', 7, false," +
            " false, true, true, true, true, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('У', 7, false," +
            " true, false, false, false, true, true)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ф', 8, false," +
            " true, true, true, false, false, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Х', 8, false," +
            " true, false, true, true, false, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ц', 8, false," +
            " true, true, false, false, false, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ч', 9, false," +
            " true, true, true, true, true, false)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ш', 9, false," +
            " true, false, false, true, false, true)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Щ', 9, false," +
            " true, true, false, false, true, true)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ъ', 10, false," +
            " true, false, true, true, true, true)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ы', 10, false," +
            " false, true, true, false, true, true)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ь', 10, false," +
            " false, true, true, true, true, true)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Э', 11, false," +
            " false, true, true, false, false, true)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ю', 11, false," +
            " true, false, true, true, false, true)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Я', 11, false," +
            " true, true, true, false, false, true)")
}