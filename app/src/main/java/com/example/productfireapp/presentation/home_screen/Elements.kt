package com.example.productfireapp.presentation.home_screen

import androidx.compose.runtime.mutableStateListOf
import com.example.productfireapp.R
import com.example.productfireapp.data.CategoryE
import com.example.productfireapp.data.Vegetable
import com.example.productfireapp.ui.theme.AvocadoColor
import com.example.productfireapp.ui.theme.GrapesColor
import com.example.productfireapp.ui.theme.LightPrimary
import com.example.productfireapp.ui.theme.PeachColor
import com.example.productfireapp.ui.theme.PineapleColor
import com.example.productfireapp.ui.theme.PomegranateColor
import javax.inject.Inject

class Elements @Inject constructor() {
    val vegList = mutableStateListOf(
        Vegetable(
            bgColor = PeachColor,
            image = R.drawable.peach,
            coast = 8.00,
            count = 0,
            name = "Fresh Peach",
            weightValue = 1.0,
            weightParameter = "dozen",
            isFavorite = false,
            isEventExist = false,
        ),
        Vegetable(
            bgColor = AvocadoColor,
            image = R.drawable.avocado,
            coast = 7.00,
            count = 0,
            name = "Avocado",
            weightValue = 2.0,
            weightParameter = "lbs",
            isFavorite = false,
            isEventExist = true,
            eventText = "new"
        ),
        Vegetable(
            bgColor = PineapleColor,
            image = R.drawable.pineapple,
            coast = 9.90,
            count = 0,
            name = "Pineapple",
            weightValue = 1.50,
            weightParameter = "lbs",
            isFavorite = false,
            isEventExist = false
        ),
        Vegetable(
            bgColor = GrapesColor,
            image = R.drawable.grapes,
            coast = 7.05,
            count = 0,
            name = "Black Grapes",
            weightValue = 5.0,
            weightParameter = "lbs",
            isFavorite = false,
            isEventExist = true,
            eventText = "-18%"
        ),
        Vegetable(
            bgColor = PomegranateColor,
            image = R.drawable.pomegranate,
            coast = 2.09,
            count = 0,
            name = "Pomegranate",
            weightValue = 1.50,
            weightParameter = "lbs",
            isFavorite = false,
            isEventExist = true,
            eventText = "new"
        ),
        Vegetable(
            bgColor = LightPrimary,
            image = R.drawable.fresh_broccoli,
            coast = 3.00,
            count = 0,
            name = "Fresh broccoli",
            weightValue = 1.0,
            weightParameter = "lbs",
            isFavorite = false,
            isEventExist = false
        )
    )

    val categoryItem = mutableStateListOf(
        CategoryE.VEGETABLES,
        CategoryE.FRUITS,
        CategoryE.BEVERAGES,
        CategoryE.GROCERY,
        CategoryE.EDITABLE_OIL,
        CategoryE.HOUSEHOLD,
        CategoryE.BABYCARE
    )
}