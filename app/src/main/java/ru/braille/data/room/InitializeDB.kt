package ru.braille.data.room

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

class InitializeDB : RoomDatabase.Callback(){
    override fun onCreate(db: SupportSQLiteDatabase){
        super.onCreate(db)
        initListLessons(db)
        initSymbol(db)
        initSymbolStatistics(db)
        initSymbolRepeat(db)
    }
}

fun initListLessons(db: SupportSQLiteDatabase){
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (1, 'А', 'Б', 'В', 0)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (2, 'Г', 'Д', 'Е', 0)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (3, 'Ё', 'Ж', 'З', 0)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (4, 'И', 'Й', 'К', 0)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (5, 'Л', 'М', 'Н', 0)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (6, 'О', 'П', 'Р', 0)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (7, 'С', 'Т', 'У', 0)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (8, 'Ф', 'Х', 'Ц', 0)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (9, 'Ч', 'Ш', 'Щ', 0)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (10, 'Ъ', 'Ы', 'Ь', 0)")
    db.execSQL("INSERT INTO lesson_table (number, symbol1, symbol2, symbol3, completed)" +
            " values (11, 'Э', 'Ю', 'Я', 0)")
}

fun initSymbol(db: SupportSQLiteDatabase) {
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('А', 1, 0," +
            " 1, 0, 0, 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Б', 1, 0," +
            " 1, 0, 1, 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('В', 1, 0," +
            " 0, 1, 1, 1, 0, 1)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Г', 2, 0," +
            " 1, 1, 1, 1, 0, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Д', 2, 0," +
            " 1, 1, 0, 1, 0, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Е', 2, 0," +
            " 1, 0, 0, 1, 0, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ё', 3, 0," +
            " 1, 0, 0, 0, 0, 1)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ж', 3, 0," +
            " 0, 1, 1, 1, 0, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('З', 3, 0," +
            " 1, 0, 0, 1, 1, 1)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('И', 4, 0," +
            " 0, 1, 1, 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Й', 4, 0," +
            " 1, 1, 1, 0, 1, 1)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('К', 4, 0," +
            " 1, 0, 0, 0, 1, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Л', 5, 0," +
            " 1, 0, 1, 0, 1, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('М', 5, 0," +
            " 1, 1, 0, 0, 1, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Н', 5, 0," +
            " 1, 1, 0, 1, 1, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('О', 6, 0," +
            " 1, 0, 0, 1, 1, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('П', 6, 0," +
            " 1, 1, 1, 0, 1, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Р', 6, 0," +
            " 1, 0, 1, 1, 1, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('С', 7, 0," +
            " 0, 1, 1, 0, 1, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Т', 7, 0," +
            " 0, 1, 1, 1, 1, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('У', 7, 0," +
            " 1, 0, 0, 0, 1, 1)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ф', 8, 0," +
            " 1, 1, 1, 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Х', 8, 0," +
            " 1, 0, 1, 1, 0, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ц', 8, 0," +
            " 1, 1, 0, 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ч', 9, 0," +
            " 1, 1, 1, 1, 1, 0)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ш', 9, 0," +
            " 1, 0, 0, 1, 0, 1)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Щ', 9, 0," +
            " 1, 1, 0, 0, 1, 1)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ъ', 10, 0," +
            " 1, 0, 1, 1, 1, 1)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ы', 10, 0," +
            " 0, 1, 1, 0, 1, 1)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ь', 10, 0," +
            " 0, 1, 1, 1, 1, 1)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Э', 11, 0," +
            " 0, 1, 1, 0, 0, 1)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Ю', 11, 0," +
            " 1, 0, 1, 1, 0, 1)")
    db.execSQL("INSERT INTO symbol_table (symbol, numberOfLesson, completed, dot1, dot2, dot3, dot4, dot5, dot6)" +
            " values ('Я', 11, 0," +
            " 1, 1, 1, 0, 0, 1)")
}

fun initSymbolStatistics(db: SupportSQLiteDatabase){
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('А', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Б', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('В', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Г', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Д', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Е', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Ё', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Ж', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('З', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('И', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Й', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('К', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Л', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('М', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Н', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('О', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('П', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Р', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('С', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Т', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('У', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Ф', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Х', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Ц', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Ч', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Ш', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Щ', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Ъ', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Ы', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Ь', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Э', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Ю', 0, 0)")
    db.execSQL("INSERT INTO symbol_statistics_table (symbol, right, wrong) " +
            "values ('Я', 0, 0)")
}

fun initSymbolRepeat(db: SupportSQLiteDatabase) {
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
                "values ('А', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Б', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('В', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Г', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Д', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Е', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Ё', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Ж', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('З', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('И', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Й', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('К', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Л', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('М', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Н', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('О', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('П', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Р', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('С', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Т', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('У', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Ф', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Х', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Ц', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Ч', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Ш', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Щ', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Ъ', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Ы', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Ь', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Э', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Ю', 0, 0, 0)")
    db.execSQL("INSERT INTO symbol_repeat_table (symbol, nextRepeat, numberOfRepeats, isRepeated) " +
            "values ('Я', 0, 0, 0)")
}