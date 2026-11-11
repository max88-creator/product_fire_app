package com.example.productfireapp.filter.filter_view_model

import androidx.compose.runtime.MutableState

interface FilterController {
    val minValueText: MutableState<String>
    val maxValueText: MutableState<String>
    val selectedStars: MutableState<Int>
    val isExistDiscount: MutableState<Boolean>
    val isExistFreeDelivery: MutableState<Boolean>
    val isExistSameDayDelivery: MutableState<Boolean>
}