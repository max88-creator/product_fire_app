package com.example.productfireapp.filter

sealed class FilterScreenEvent {
    object OnClearFilters: FilterScreenEvent()
    object OnApplyFilters: FilterScreenEvent()
    object OnExistDiscountClick: FilterScreenEvent()
    object OnFreeDeliveryClick: FilterScreenEvent()
    object OnSameDayDeliveryClick: FilterScreenEvent()
    data class OnStarsClick(val selectedStars: Int): FilterScreenEvent()
    data class OnMinValueTextChange(val value: String): FilterScreenEvent()
    data class OnMaxValueTextChange(val value: String): FilterScreenEvent()
}