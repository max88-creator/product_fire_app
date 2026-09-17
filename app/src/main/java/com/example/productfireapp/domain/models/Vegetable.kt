package com.example.productfireapp.domain.models

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vegetable")
data class Vegetable(
    @PrimaryKey
    val id: Int,
    val bgColor: Color = Color.White,
    val image: Int =0,
    val coast: Double = 0.0,
    val count: Int = 0,
    val name: String = "",
    val weightValue: Double = 0.0,
    val weightParameter: String = "",
    val isEventExist: Boolean = false,
    val eventText: String = "",
    val eventTextColor: Color = Color.White
)