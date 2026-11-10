package com.example.productfireapp.filter

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
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
   override var selectedStars = mutableIntStateOf(0)
       private set
    override var isExistDiscount = mutableStateOf(false)
        private set
    override var isExistFreeDelivery = mutableStateOf(false)
        private set
    override var isExistSameDayDelivery = mutableStateOf(false)
        private set
    fun onEvent(event: FilterScreenEvent) {
        when (event) {
            is FilterScreenEvent.OnMinValueTextChange -> {
                minValueText.value = event.value
            }
            is FilterScreenEvent.OnMaxValueTextChange -> {
                maxValueText.value = event.value
            }
            is FilterScreenEvent.OnExistDiscountClick -> {
                isExistDiscount.value = !isExistDiscount.value
            }
            is FilterScreenEvent.OnFreeDeliveryClick -> {
                isExistFreeDelivery.value = !isExistFreeDelivery.value
            }
            is FilterScreenEvent.OnSameDayDeliveryClick -> {
                isExistSameDayDelivery.value = !isExistSameDayDelivery.value
            }
            is FilterScreenEvent.OnStarsClick -> {
                selectedStars.intValue = event.selectedStars
            }
            is FilterScreenEvent.OnApplyFilters -> {}
            is FilterScreenEvent.OnClearFilters -> {
                minValueText.value = ""
                maxValueText.value = ""
                isExistDiscount.value = false
                isExistFreeDelivery.value = false
                isExistSameDayDelivery.value = false
            }
        }
    }
}