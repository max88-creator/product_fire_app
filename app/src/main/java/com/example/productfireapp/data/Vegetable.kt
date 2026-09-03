package com.example.productfireapp.data

import androidx.compose.ui.graphics.Color

data class Vegetable(
    val bgColor: Color,
    val image: Int,
    var coast: Double,
    var count: Int = 0,
    val name: String,
    var weight: String,
    var isAdded: Boolean,
    var isFavorite: Boolean,
    var isEventExist: Boolean,
    var eventText: String = "",
    var eventTextColor: Color = Color.White
)
