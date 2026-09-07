package com.example.productfireapp.data

import androidx.compose.ui.graphics.Color
import com.example.productfireapp.R
import com.example.productfireapp.ui.theme.AvocadoColor
import com.example.productfireapp.ui.theme.GrapesColor
import com.example.productfireapp.ui.theme.LightPrimary
import com.example.productfireapp.ui.theme.PeachColor
import com.example.productfireapp.ui.theme.PineapleColor
import com.example.productfireapp.ui.theme.PomegranateColor

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

enum class VegetableE(
    val bgColor: Color,
    val symbol: Int,
    var coast: Double,
    var count: Int = 0,
    val label: String,
    var weight: String,
    var isAdded: Boolean,
    var isFavorite: Boolean,
    var isEventExist: Boolean,
    var eventText: String = "",
    var eventTextColor: Color = Color.White
) {
    FRESH_PEACH(
        bgColor = PeachColor,
        symbol = R.drawable.peach,
        coast = 0.0,
        label = "Fresh Peach",
        weight = "dozen",
        isAdded = false,
        isFavorite = false,
        isEventExist = false
    ),
    AVOCADO(
        bgColor = AvocadoColor,
        symbol= R.drawable.avocado,
        coast = 0.0,
        label = "Avocado",
        weight = "2.0 lbs",
        isAdded = false,
        isFavorite = false,
        isEventExist = false
    ),
    PINEAPPLE(
        bgColor = PineapleColor,
        symbol = R.drawable.pineapple,
        coast = 0.0,
        label = "Pineapple",
        weight = "1.50 lbs",
        isAdded = false,
        isFavorite = false,
        isEventExist = false
    ),
    BLACK_GRAPES(
        bgColor = GrapesColor,
        symbol = R.drawable.grapes,
        coast = 0.0,
        label = "Black Grapes",
        weight = "5.0 lbs",
        isAdded = false,
        isFavorite = false,
        isEventExist = false
    ),
    POMEGRANATE(
        bgColor = PomegranateColor,
        symbol = R.drawable.pomegranate,
        coast = 0.0,
        label = "Pomegranate",
        weight = "1.50 lbs",
        isAdded = false,
        isFavorite = false,
        isEventExist = false
    ),
    FRESH_BROCCOLI(
        bgColor = LightPrimary,
        symbol = R.drawable.fresh_broccoli,
        coast = 0.0,
        label = "Fresh broccoli",
        weight = "1.50 lbs",
        isAdded = false,
        isFavorite = false,
        isEventExist = false
    )
}
