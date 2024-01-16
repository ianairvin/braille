package ru.braille.domain.repository

import ru.braille.domain.entities.Lesson

interface LessonRepository {
    suspend fun getListLessons() : List<Lesson>
}