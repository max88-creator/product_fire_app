package com.example.productfireapp.filter

sealed class FilterScreenEvent {
    object OnClearFilters : FilterScreenEvent()
    object OnApplyFilters : FilterScreenEvent()
    data class OnTextChange(val value: String): FilterScreenEvent()
}