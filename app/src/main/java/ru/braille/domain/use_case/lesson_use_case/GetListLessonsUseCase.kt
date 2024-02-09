package ru.braille.domain.use_case.lesson_use_case

import kotlinx.coroutines.flow.Flow
import ru.braille.domain.entities.Lesson
import ru.braille.domain.repository.LessonRepository
import javax.inject.Inject

class GetListLessonsUseCase @Inject constructor (
    private val lessonRepository: LessonRepository
){
    operator fun invoke() : Flow<List<Lesson>> {
        return lessonRepository.getListLessons()
    }
}