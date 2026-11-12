package com.example.productfireapp.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.productfireapp.presentation.screens.basket_screen.BasketScreen
import com.example.productfireapp.bottom_nav_bar.data.BottomMenuItem
import com.example.productfireapp.bottom_nav_bar.ui.BottomMenu
import com.example.productfireapp.presentation.screens.filter.FilterResultScreen
import com.example.productfireapp.presentation.screens.filter.FilterScreen
import com.example.productfireapp.presentation.screens.filter.SearchResultScreen
import com.example.productfireapp.presentation.screens.favorites.FavoritesList
import com.example.productfireapp.presentation.screens.home_screen.HomeScreen
import com.example.productfireapp.presentation.screens.home_screen.ProductsList
import com.example.productfireapp.user_screen.UserScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    val viewModelStoreOwner = requireNotNull(
        LocalViewModelStoreOwner.current
    ) { "ViewModelStoreOwner должен быть доступен внутри NavHost" }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val destination = navBackStackEntry?.destination

    val showBottomMenu =
        destination?.hasRoute<NavigationRoutes.Basket>() != true &&
                destination?.hasRoute<NavigationRoutes.Favorites>() != true &&
                destination?.hasRoute<NavigationRoutes.ProductList>() != true &&
                destination?.hasRoute<NavigationRoutes.Filter>() != true &&
                destination?.hasRoute<NavigationRoutes.SearchResult>() != true

    var selectedItemTitle by rememberSaveable {
        mutableStateOf(BottomMenuItem.Home.title)
    }
    Scaffold(
        bottomBar = {
            if (showBottomMenu) {
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
            composable<NavigationRoutes.Home>(
                enterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(
                            durationMillis = 500,
                            easing = FastOutSlowInEasing
                        )
                    )
                }
            ) {
                HomeScreen(
                    toProductListNavigate = {
                        navController.navigate(NavigationRoutes.ProductList)
                    },
                    toFilterScreenClick = {
                        navController.navigate(NavigationRoutes.Filter)
                    },
                    onSearchResultClick = {
                        navController.navigate(NavigationRoutes.SearchResult)
                    }
                )
            }

            composable<NavigationRoutes.SearchResult> {
                SearchResultScreen(
                    onFilterScreen = {
                        navController.navigate(NavigationRoutes.Filter)
                    },
                    viewModelStoreOwner = viewModelStoreOwner
                )
            }
            composable<NavigationRoutes.FilterResult> {
                FilterResultScreen()
            }
            composable<NavigationRoutes.User>(
                enterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(
                            durationMillis = 500,
                            easing = FastOutSlowInEasing
                        )
                    )
                }
            ) { UserScreen() }

            composable<NavigationRoutes.Basket>(
                enterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(
                            durationMillis = 500,
                            easing = FastOutSlowInEasing
                        )
                    )
                }
            ) {
                BasketScreen(
                    backClick = {
                        navController.popBackStack()
                    }
                )
            }

            composable<NavigationRoutes.Favorites>(
                enterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(
                            durationMillis = 500,
                            easing = FastOutSlowInEasing
                        )
                    )
                }
            ) {
                FavoritesList(
                    backToHome = {
                        navController.popBackStack()
                    }
                )
            }

            composable<NavigationRoutes.ProductList> (
                enterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(
                            durationMillis = 500,
                            easing = FastOutSlowInEasing
                        )
                    )
                }
            ) {
                ProductsList(
                    backToHomeScreenClick = {
                        navController.popBackStack()
                    }
                )
            }

            composable<NavigationRoutes.Filter>() {
                FilterScreen(
                    backToHomeClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}


