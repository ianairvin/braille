package ru.braille.domain.use_case.lesson_use_case

import ru.braille.domain.entities.Lesson
import ru.braille.domain.repository.LessonRepository
import javax.inject.Inject

class UpdateLessonUseCase @Inject constructor(
    val lessonRepository: LessonRepository
) {
    suspend operator fun invoke(lesson: Lesson) {
        lessonRepository.updateLesson(lesson)
    }
}