package ru.braille.data.repository

import ru.braille.data.room.Dao
import ru.braille.domain.entities.Lesson
import ru.braille.domain.repository.ListLessonsRepository
import javax.inject.Inject

class ListLessonsRepositoryImpl @Inject constructor(
    private val dao: Dao
) : ListLessonsRepository {
    override suspend fun getListLessons(): List<Lesson> {
        val listLessons = arrayListOf<Lesson>()
        val listLessonsDB = dao.getListLessons()
        listLessonsDB.forEach{
            val item = Lesson(
                number = it.number,
                symbol1 = it.symbol1,
                symbol2 = it.symbol2,
                symbol3 = it.symbol3,
                completed = it.completed
            )
            listLessons.add(item)
        }
        return listLessons
    }
}