package com.example.league_of_legends_app_compose.navigation.navhosts

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.league_of_legends_app_compose.features.home.presentation.ui.HomeScreen
import com.example.league_of_legends_app_compose.navigation.routes.MainRoute.HomeRoute
import com.example.league_of_legends_app_compose.navigation.routes.MainRoute.MainGraph


fun NavGraphBuilder.mainNavHost(
    navController: NavHostController
) {
    navigation<MainGraph>(
        startDestination = HomeRoute
    ) {
        composable<HomeRoute> {
            HomeScreen()
        }
    }
}

