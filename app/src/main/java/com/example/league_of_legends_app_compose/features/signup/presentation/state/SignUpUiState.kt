package com.example.league_of_legends_app_compose.features.signup.presentation.state

data class SignUpUiState(
    val email: String = "",
    val isErrorEmail: Boolean = false,
    val username: String = "",
    val isErrorUsername: Boolean = false,
    val password: String = "",
    val isErrorPassword: Boolean = false,
    val repeatPassword: String = "",
    val isErrorRepeatPassword: Boolean = false,
    val isLoading: Boolean = false,
    val snackbarMessage: String? = null
)
