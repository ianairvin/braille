package ru.braille.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.braille.domain.entities.Lesson

interface LessonRepository {
    fun getListLessons() : Flow<List<Lesson>>
    suspend fun updateLesson(lesson: Lesson)

    suspend fun statusCompleteLesson(numberOfLesson: Int): Boolean
}