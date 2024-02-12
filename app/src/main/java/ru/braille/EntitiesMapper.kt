package ru.braille

import ru.braille.data.room.entities.LessonDB
import ru.braille.data.room.entities.SymbolDB
import ru.braille.data.room.entities.SymbolRepeatDB
import ru.braille.data.room.entities.SymbolStatisticsDB
import ru.braille.domain.entities.Lesson
import ru.braille.domain.entities.Symbol
import ru.braille.domain.entities.SymbolRepeat
import ru.braille.domain.entities.SymbolStatistics
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime

fun Lesson.toLessonDB() : LessonDB {
    return LessonDB(
        this.number,
        this.symbol1,
        this.symbol2,
        this.symbol3,
        if (this.completed) 1 else 0
    )
}

fun LessonDB.toLesson() : Lesson {
    return Lesson(
        this.number,
        this.symbol1,
        this.symbol2,
        this.symbol3,
        this.completed == 1
    )
}

fun SymbolStatisticsDB.toSymbolStatistics() : SymbolStatistics {
    return SymbolStatistics(
        this.symbol,
        this.right,
        this.wrong
    )
}

fun SymbolDB.toSymbol() : Symbol {
    return Symbol(
        this.symbol,
        this.numberOfLesson,
        this.completed == 1,
        this.dot1 == 1,
        this.dot2 == 1,
        this.dot3 == 1,
        this.dot4 == 1,
        this.dot5 == 1,
        this.dot6 == 1
    )
}
fun Symbol.toSymbolDB() : SymbolDB {
    return SymbolDB(
        this.symbol,
        this.numberOfLesson,
        if (this.completed) 1 else 0,
        if (this.dot1) 1 else 0,
        if (this.dot2) 1 else 0,
        if (this.dot3) 1 else 0,
        if (this.dot4) 1 else 0,
        if (this.dot5) 1 else 0,
        if (this.dot6) 1 else 0
    )
}

fun SymbolRepeatDB.toSymbolRepeat() : SymbolRepeat {
    return SymbolRepeat(
        this.symbol,
        LocalDateTime.ofInstant(Instant.ofEpochMilli(this.nextRepeat), ZoneId.systemDefault()),
        this.numberOfRepeats,
        this.isRepeated != 0
    )
}

fun SymbolRepeat.toSymbolRepeatDB() : SymbolRepeatDB {
    return SymbolRepeatDB(
        this.symbol,
        ZonedDateTime.of(this.nextRepeat, ZoneId.systemDefault()).toInstant().toEpochMilli(),
        this.numberOfRepeats,
        if(this.isRepeated) 1 else 0
    )
}
