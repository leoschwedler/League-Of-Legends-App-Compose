package com.example.league_of_legends_app_compose.features.login.presentation.state

data class LoginUiState(
    val email: String = "",
    val isErrorEmail: Boolean = false,
    val password: String = "",
    val isErrorPassword: Boolean = false,
    val isLoading: Boolean = false,
)
