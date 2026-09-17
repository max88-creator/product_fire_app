package com.example.productfireapp.utils

import androidx.compose.ui.graphics.Color
import androidx.room.TypeConverter


class ConvertColors {

    @TypeConverter
    fun mapToLong(color: Color): Long {
        return color.value.toLong()
    }

    @TypeConverter
    fun mapFromLong(value: Long): Color {
        val newValue = value.toULong()
        val createdColor = Color(newValue)
        return createdColor
    }
}