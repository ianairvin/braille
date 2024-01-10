package ru.braille.data.repository

import ru.braille.data.room.Dao
import ru.braille.domain.repository.ListLessonsRepository
import javax.inject.Inject

class ListLessonsRepositoryImpl @Inject constructor(
    private val dao: Dao
) : ListLessonsRepository {
}