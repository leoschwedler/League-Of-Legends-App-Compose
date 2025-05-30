package com.example.league_of_legends_app_compose.navigation.navhosts

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.league_of_legends_app_compose.commom.extensions.slideInTo
import com.example.league_of_legends_app_compose.commom.extensions.slideOutTo
import com.example.league_of_legends_app_compose.features.login.presentation.ui.LoginScreen
import com.example.league_of_legends_app_compose.features.onboarding.presentation.Onboarding1Screen
import com.example.league_of_legends_app_compose.features.onboarding.presentation.Onboarding2Screen
import com.example.league_of_legends_app_compose.features.onboarding.presentation.Onboarding3Screen
import com.example.league_of_legends_app_compose.features.onboarding.presentation.Onboarding4Screen
import com.example.league_of_legends_app_compose.features.signup.presentation.ui.SignUpScreen
import com.example.league_of_legends_app_compose.features.splash.ui.SplashScreen
import com.example.league_of_legends_app_compose.navigation.routes.MainRoute
import com.example.league_of_legends_app_compose.navigation.routes.OnboardingRoute
import com.example.league_of_legends_app_compose.navigation.routes.OnboardingRoute.*

@Composable
fun OnboardingNavHost() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = SplashScreenRoute) {

        composable<SplashScreenRoute>(
            enterTransition = {
                this.slideInTo(AnimatedContentTransitionScope.SlideDirection.Left)
            },
            exitTransition = {
                this.slideOutTo(AnimatedContentTransitionScope.SlideDirection.Right)
            }
        ) {
            SplashScreen(
                naviteToOnboarding1 = {
                    navController.navigate(Onboarding1Route)
                }
            )
        }
        composable<Onboarding1Route>(
            enterTransition = {
                this.slideInTo(AnimatedContentTransitionScope.SlideDirection.Left)
            },
            exitTransition = {
                this.slideOutTo(AnimatedContentTransitionScope.SlideDirection.Right)
            }
        ) {
            Onboarding1Screen(
                naviteToOnboarding2 = {
                    navController.navigate(Onboarding2Route)
                }
            )
        }
        composable<Onboarding2Route>(
            enterTransition = {
                this.slideInTo(AnimatedContentTransitionScope.SlideDirection.Left)
            },
            exitTransition = {
                this.slideOutTo(AnimatedContentTransitionScope.SlideDirection.Right)
            }
        ) {
            Onboarding2Screen(
                naviteToOnboarding3 = {
                    navController.navigate(Onboarding3Route)
                }
            )
        }
        composable<Onboarding3Route>(
            enterTransition = {
                this.slideInTo(AnimatedContentTransitionScope.SlideDirection.Left)
            },
            exitTransition = {
                this.slideOutTo(AnimatedContentTransitionScope.SlideDirection.Right)
            }
        ) {
            Onboarding3Screen(
                navigatoToOnboarding4 = {
                    navController.navigate(Onboarding4Route){
                        popUpTo(SplashScreenRoute){
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<Onboarding4Route>(
            enterTransition = {
                this.slideInTo(AnimatedContentTransitionScope.SlideDirection.Left)
            },
            exitTransition = {
                this.slideOutTo(AnimatedContentTransitionScope.SlideDirection.Right)
            }
        ) {
            Onboarding4Screen(

                navigateToSignUp = {
                    navController.navigate(SignUpRoute)
                },
                navigateToLogin = {
                    navController.navigate(LoginRoute)
                }
            )
        }
        composable<SignUpRoute>(
            enterTransition = {
                this.slideInTo(AnimatedContentTransitionScope.SlideDirection.Left)
            },
            exitTransition = {
                this.slideOutTo(AnimatedContentTransitionScope.SlideDirection.Right)
            }
        ) {
            SignUpScreen(
                onbackPressed = {
                    navController.popBackStack()
                },
                navigateToHome = {
                    navController.navigate(LoginRoute)
                }
            )
        }
        composable<LoginRoute> {
            LoginScreen(
                onbackPressed = {
                    navController.navigate(Onboarding4Route)
                },
                navigateToHome = {
                    navController.navigate(MainRoute.HomeRoute)
                }
            )
        }
        mainNavHost(navController = navController)
    }
}