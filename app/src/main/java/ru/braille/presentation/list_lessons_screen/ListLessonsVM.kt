package ru.braille.presentation.list_lessons_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.braille.domain.entities.Lesson
import ru.braille.domain.use_case.lesson_use_case.GetListLessonsUseCase
import javax.inject.Inject

@HiltViewModel
class ListLessonsVM @Inject constructor (
    private val getListLessonsUseCase: GetListLessonsUseCase
): ViewModel() {
    var listLessons = mutableStateOf(emptyList<Lesson>())
    private fun getList() = viewModelScope.launch{
        listLessons.value = getListLessonsUseCase()
    }
    init{
        getList()
    }

}