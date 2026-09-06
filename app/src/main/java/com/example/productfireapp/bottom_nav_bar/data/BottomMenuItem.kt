package com.example.productfireapp.bottom_nav_bar.data

import com.example.productfireapp.R

sealed class BottomMenuItem(
    val title: String,
    val iconId: Int
) {
    data object Home : BottomMenuItem(title = "Home", iconId = R.drawable.ic_home)
    data object User : BottomMenuItem(title = "User", iconId = R.drawable.rounded_person_icon)
    data object Favorites : BottomMenuItem(title = "Favorites", R.drawable.empty_heart)
    data object Basket : BottomMenuItem(title = "Basket", R.drawable.green_basket)
}