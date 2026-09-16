package com.example.productfireapp.data

import androidx.compose.ui.graphics.Color
import androidx.room.Entity

@Entity(tableName = "vegetable")
data class Vegetable(
    val bgColor: Color = Color.White,
    val image: Int =0,
    val coast: Double = 0.0,
    val count: Int = 0,
    val name: String = "",
    val weightValue: Double = 0.0,
    val weightParameter: String = "",
    val isFavorite: Boolean = false,
    val isEventExist: Boolean = false,
    val eventText: String = "",
    val eventTextColor: Color = Color.White
)



