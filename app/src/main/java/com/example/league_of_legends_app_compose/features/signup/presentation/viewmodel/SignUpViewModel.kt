package com.example.league_of_legends_app_compose.features.signup.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.league_of_legends_app_compose.features.signup.data.repository.SignUpRepository
import com.example.league_of_legends_app_compose.features.signup.presentation.action.SignUpAction
import com.example.league_of_legends_app_compose.features.signup.presentation.event.SignUpEvent
import com.example.league_of_legends_app_compose.features.signup.presentation.state.SignUpUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val repository: SignUpRepository) : ViewModel() {

    private val _state = MutableStateFlow(SignUpUiState())
    val state = _state.asStateFlow()

    private val _uiEvent = Channel<SignUpEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAction(action: SignUpAction) {
        when (action) {
            is SignUpAction.onEmailChanged -> {
                _state.update { it.copy(email = action.email) }

            }

            is SignUpAction.onUsernameChanged -> {
                _state.update { it.copy(username = action.username) }
            }

            is SignUpAction.onPasswordChanged -> {
                _state.update { it.copy(password = action.password) }
            }

            is SignUpAction.onRepeatPasswordChanged -> {
                _state.update { it.copy(repeatPassword = action.repeatPassword) }
            }

            SignUpAction.Submit -> {
                registerUser()
            }

        }
    }

    private fun registerUser() {
        // Zera os erros e a mensagem de snackbar
        _state.update {
            it.copy(
                isErrorEmail = false,
                isErrorUsername = false,
                isErrorPassword = false,
                isErrorRepeatPassword = false,
                snackbarMessage = null
            )
        }

        val currentState = _state.value

        if (currentState.email.isBlank()) {
            _state.update { it.copy(isErrorEmail = true) }
            viewModelScope.launch {
                _uiEvent.send(SignUpEvent.ShowSnackbar("Email é obrigatório"))
            }
            return
        }
        if (currentState.username.isBlank()) {
            _state.update { it.copy(isErrorUsername = true) }
            viewModelScope.launch {
                _uiEvent.send(SignUpEvent.ShowSnackbar("Username é obrigatório"))
            }
            return
        }
        if (currentState.password.isBlank()) {
            _state.update { it.copy(isErrorPassword = true) }
            viewModelScope.launch {
                _uiEvent.send(SignUpEvent.ShowSnackbar("Senha é obrigatório"))
            }
            return
        }
        if (currentState.repeatPassword.isBlank()) {
            _state.update { it.copy(isErrorRepeatPassword = true) }
            viewModelScope.launch {
                _uiEvent.send(SignUpEvent.ShowSnackbar("repita a senha"))
            }
            return
        }

        if (currentState.password != currentState.repeatPassword) {
            _state.update {
                it.copy(
                    isErrorPassword = true,
                    isErrorRepeatPassword = true,
                )
            }
            viewModelScope.launch {
                _uiEvent.send(SignUpEvent.ShowSnackbar("As senhas não coincidem"))
            }
            return
        }
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch(Dispatchers.IO) {
             repository.insertAll(
                email = _state.value.email,
                username = _state.value.username,
                password = _state.value.password
            )
            _uiEvent.send(SignUpEvent.NavigateToHome)
        }
    }
}