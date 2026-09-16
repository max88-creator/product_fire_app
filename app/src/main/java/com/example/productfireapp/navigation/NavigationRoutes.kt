package com.example.productfireapp.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface NavigationRoutes {
    @Serializable
    data object Home: NavigationRoutes
    @Serializable
    data object User: NavigationRoutes
    @Serializable
    data object Favorites: NavigationRoutes
    @Serializable
    data object ProductList: NavigationRoutes
    @Serializable
    data object Basket: NavigationRoutes
}
