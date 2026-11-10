package com.example.productfireapp.filter

sealed class FilterScreenEvent {
    object OnClearFilters : FilterScreenEvent()
    object OnApplyFilters : FilterScreenEvent()
    data class OnMinValueTextChange(val value: String): FilterScreenEvent()
    data class OnMaxValueTextChange(val value: String): FilterScreenEvent()
}