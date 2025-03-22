package com.example.league_of_legends_app_compose.navigation.routes

import kotlinx.serialization.Serializable

sealed class OnboardingRoute {

    @Serializable
    data object SplashScreenRoute: OnboardingRoute()
    @Serializable
    data object Onboarding1Route: OnboardingRoute()
    @Serializable
    data object Onboarding2Route: OnboardingRoute()
    @Serializable
    data object Onboarding3Route: OnboardingRoute()
    @Serializable
    data object Onboarding4Route: OnboardingRoute()
    @Serializable
    data object SignUpRoute: OnboardingRoute()
    @Serializable
    data object LoginRoute: OnboardingRoute()



}