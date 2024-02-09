package ru.braille.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.braille.data.room.Dao
import ru.braille.data.room.entities.LessonDB
import ru.braille.domain.entities.Lesson
import ru.braille.domain.repository.LessonRepository
import ru.braille.toLesson
import ru.braille.toLessonDB
import javax.inject.Inject

class LessonRepositoryImpl @Inject constructor(
    private val dao: Dao
) : LessonRepository {
    override fun getListLessons(): Flow<List<Lesson>> {
        val listDB = dao.getListLessons()
        val list: Flow<List<Lesson>> = listDB.map {
            listDB -> listDB.map { it.toLesson() }
        }
        return list
    }

    override suspend fun updateLesson(lesson: Lesson) {
        dao.updateLesson(lesson.toLessonDB())
    }

    override suspend fun statusCompleteLesson(numberOfLesson: Int): Boolean {
        return dao.statusCompleteLesson(numberOfLesson) == 1
    }
}