package com.example.productfireapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.productfireapp.basket_screen.BasketScreen
import com.example.productfireapp.favorites_screen.FavoritesList
import com.example.productfireapp.home_screen.HomeScreen
import com.example.productfireapp.user_screen.UserScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.Home,
//        modifier = TODO(),
//        contentAlignment = TODO(),
//        route = TODO(),
//        typeMap = TODO(),
//        enterTransition = TODO(),
//        exitTransition = TODO(),
//        popEnterTransition = TODO(),
//        popExitTransition = TODO(),
//        sizeTransform = TODO()
    ) {
        composable (NavigationRoutes.Home.route){ HomeScreen() }
        composable (NavigationRoutes.User.route){ UserScreen() }
        composable (NavigationRoutes.Favorites.route){ FavoritesList() }
        composable (NavigationRoutes.Basket.route){ BasketScreen() }
    }
}