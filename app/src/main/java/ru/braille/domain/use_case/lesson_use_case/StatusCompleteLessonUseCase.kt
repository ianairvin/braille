package ru.braille.domain.use_case.lesson_use_case

import ru.braille.domain.repository.LessonRepository
import javax.inject.Inject

class StatusCompleteLessonUseCase @Inject constructor(
    val lessonRepository: LessonRepository
) {
    suspend operator fun invoke(numberOfLesson: Int) : Boolean {
        return lessonRepository.statusCompleteLesson(numberOfLesson)
    }
}