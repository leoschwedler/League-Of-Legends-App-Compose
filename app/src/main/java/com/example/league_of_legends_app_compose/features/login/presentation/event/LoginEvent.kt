package com.example.league_of_legends_app_compose.features.login.presentation.event

sealed interface LoginEvent {
    data class ShowSnackbar(val message: String) : LoginEvent
    object NavigateToHome : LoginEvent

}