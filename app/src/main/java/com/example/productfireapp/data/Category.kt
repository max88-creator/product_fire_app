package com.example.productfireapp.data

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

//@Entity(tableName = "category")
//data class Category(
//    @PrimaryKey(autoGenerate = true)
//    val id: Int? = null,
//    val icon: Int,
//    val name: String
//)


data class Category(
    val image: Int,
    val name: String,
    val bgColor: Color,
    val modifier: Modifier = Modifier
)