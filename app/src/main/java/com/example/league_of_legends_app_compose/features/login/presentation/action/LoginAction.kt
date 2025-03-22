package com.example.league_of_legends_app_compose.features.login.presentation.action

sealed class LoginAction {
    data class EmailChanged(val email: String) : LoginAction()
    data class PasswordChanged(val password: String) : LoginAction()
    data object onSubmit : LoginAction()
}