package com.example.league_of_legends_app_compose.features.signup.presentation.action

sealed class SignUpAction {
    data class onEmailChanged(val email: String) : SignUpAction()
    data class onUsernameChanged(val username: String) : SignUpAction()
    data class onPasswordChanged(val password: String) : SignUpAction()
    data class onRepeatPasswordChanged(val repeatPassword: String) : SignUpAction()
    object Submit : SignUpAction()
}