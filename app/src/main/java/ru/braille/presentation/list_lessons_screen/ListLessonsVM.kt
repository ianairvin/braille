package ru.braille.presentation.list_lessons_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.braille.domain.use_case.lesson_use_case.GetListLessonsUseCase
import javax.inject.Inject

@HiltViewModel
class ListLessonsVM @Inject constructor(
    private val getListLessonsUseCase: GetListLessonsUseCase
) : ViewModel() {

    var listLessons = getListLessonsUseCase()
    var selectedLesson = mutableStateOf(1)

}