package com.example.productfireapp.navigation

import kotlinx.serialization.Serializable

sealed class NavigationRoutes(val route: String) {

    object Home : NavigationRoutes(route = "Home")

    object User : NavigationRoutes(route = "User")

    object Favorites : NavigationRoutes(route = "Favorites")

    object Basket : NavigationRoutes(route = "Basket")
}