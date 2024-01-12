package ru.braille.domain.repository

import ru.braille.domain.entities.Lesson

interface ListLessonsRepository {
    suspend fun getListLessons() : List<Lesson>
}