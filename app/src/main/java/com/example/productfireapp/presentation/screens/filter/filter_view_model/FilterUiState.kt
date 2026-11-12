package com.example.productfireapp.presentation.screens.filter.filter_view_model

import com.example.productfireapp.domain.models.Vegetable

data class FilterUiState(
    val getFilteredVegetables: List<Vegetable> = emptyList(),
    val minValue: String = "",
    val maxValue: String = "",
    val isFilledStar: Boolean = false,
    val starsCount: Int = 0,
    val isDiscount: Boolean = false,
    val isFreeShipping: Boolean = false,
    val isSameDayDelivery: Boolean = false
)

