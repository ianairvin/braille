package ru.braille.domain.use_case.list_lessons_use_case

import ru.braille.domain.entities.Lesson
import ru.braille.domain.repository.ListLessonsRepository
import javax.inject.Inject

class GetListLessonsUseCase @Inject constructor (
    private val listLessonsRepository: ListLessonsRepository
){
    suspend operator fun invoke() : List<Lesson>{
        return listLessonsRepository.getListLessons()
    }
}