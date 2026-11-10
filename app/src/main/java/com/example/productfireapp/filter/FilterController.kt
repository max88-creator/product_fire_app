package com.example.productfireapp.filter

import androidx.compose.runtime.MutableState

interface FilterController {
    val minValueText: MutableState<String>
    val maxValueText: MutableState<String>
}