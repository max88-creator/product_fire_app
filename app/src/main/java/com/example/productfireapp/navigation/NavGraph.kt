package com.example.productfireapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.productfireapp.basket_screen.BasketScreen
import com.example.productfireapp.bottom_nav_bar.data.BottomMenuItem
import com.example.productfireapp.bottom_nav_bar.ui.BottomMenu
import com.example.productfireapp.presentation.favorites.FavoritesList
import com.example.productfireapp.presentation.home_screen.HomeScreen
import com.example.productfireapp.presentation.home_screen.ProductsList
import com.example.productfireapp.user_screen.UserScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    var selectedItemTitle by rememberSaveable {
        mutableStateOf(BottomMenuItem.Home.title)
    }
    Scaffold(
        bottomBar = {
            BottomMenu(
                selectedItemTitle = selectedItemTitle,
                onItemClick = { title ->
                    selectedItemTitle = title
                    val destination = when (title) {
                        BottomMenuItem.Home.title -> NavigationRoutes.Home
                        BottomMenuItem.User.title -> NavigationRoutes.User
                        BottomMenuItem.Favorites.title -> NavigationRoutes.Favorites
                        BottomMenuItem.Basket.title -> NavigationRoutes.Basket
                        else -> return@BottomMenu
                    }
                    navController.navigate(destination) {
                        popUpTo(NavigationRoutes.Home) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = NavigationRoutes.Home,
            modifier = Modifier
                .padding(paddingValues),
            //route = TODO(),
            //   typeMap = TODO(),
            //   enterTransition = TODO(),
            //   exitTransition = TODO(),
            //    popEnterTransition = TODO(),
            //    popExitTransition = TODO(),
            //     sizeTransform = TODO()
        ) {
            composable<NavigationRoutes.Home> {
                HomeScreen(
                    toProductListNavigate = {
                        navController.navigate(NavigationRoutes.ProductList)
                    }
                )
            }
            composable<NavigationRoutes.User> { UserScreen() }
            composable<NavigationRoutes.Favorites> {
                FavoritesList(
            backToHome = {
                navController.navigate(NavigationRoutes.Home)
            }
                )
            }
            composable<NavigationRoutes.Basket> {
                BasketScreen(
                    backClick = { navController.navigate(NavigationRoutes.Home) }
                )
            }
            composable<NavigationRoutes.ProductList> {
                ProductsList(
                    backToHomeScreenClick = {
                        navController.navigate(NavigationRoutes.Home)
                    }
                )
            }

        }
    }
}