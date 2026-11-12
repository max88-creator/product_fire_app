package com.example.productfireapp.presentation.screens.filter.filter_view_model

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productfireapp.domain.models.Vegetable
import com.example.productfireapp.domain.repositories.VegetableRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import kotlin.collections.filter

@HiltViewModel
class FilterViewModel @Inject constructor(
    private val repository: VegetableRepository
) :
    ViewModel(), FilterController {

    val vegetables = repository.getAllVegetable()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = emptyList()
        )


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


    fun filterByPrice(): List<Vegetable> {
        return vegetables.value.filter { vegetable ->
            minValueText.value.toDoubleOrNull()?.let { vegetable.coast >= it } ?: true &&
                    maxValueText.value.toDoubleOrNull()?.let { vegetable.coast <= it } ?: true
        }
    }

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

            is FilterScreenEvent.OnApplyFilters -> {
                _filterUiState.update { state ->
                    state.copy(
                        getFilteredVegetables = filterByPrice()
                    )
                }
            }

            is FilterScreenEvent.OnClearFilters -> {
                minValueText.value = ""
                maxValueText.value = ""
                isExistDiscount.value = false
                isExistFreeDelivery.value = false
                isExistSameDayDelivery.value = false
                selectedStars.intValue = 0
            }
        }
    }
}

