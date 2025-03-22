package com.example.league_of_legends_app_compose.features.signup.presentation.event

import com.example.league_of_legends_app_compose.features.signup.presentation.action.SignUpAction

sealed interface SignUpEvent {
    data class ShowSnackbar(val message: String) : SignUpEvent
    object NavigateToHome : SignUpEvent
}