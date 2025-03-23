package com.example.league_of_legends_app_compose.navigation.routes

import kotlinx.serialization.Serializable

sealed class MainRoute {

    @Serializable
    data object MainGraph : MainRoute()

    @Serializable
    data object HomeRoute : MainRoute()
}