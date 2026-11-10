package com.example.productfireapp.filter

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor():
    ViewModel(), FilterController {
    private val _filterUiState = MutableStateFlow(
        FilterUiState()
    )
    val filterUiState = _filterUiState.asStateFlow()
    override var minValueText = mutableStateOf("")
        private set
    override var maxValueText = mutableStateOf("")
        private set
    fun onEvent(event: FilterScreenEvent) {
        when (event) {
            is FilterScreenEvent.OnMinValueTextChange -> {
                minValueText.value = event.value
            }
            is FilterScreenEvent.OnMaxValueTextChange -> {
                maxValueText.value = event.value
            }
            is FilterScreenEvent.OnApplyFilters -> {}
            is FilterScreenEvent.OnClearFilters -> {
                minValueText.value = ""
                maxValueText.value = ""
            }
        }
    }
}