package com.example.league_of_legends_app_compose.features.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.league_of_legends_app_compose.features.login.data.repository.LoginRepository
import com.example.league_of_legends_app_compose.features.login.presentation.action.LoginAction
import com.example.league_of_legends_app_compose.features.login.presentation.event.LoginEvent
import com.example.league_of_legends_app_compose.features.login.presentation.state.LoginUiState
import com.example.league_of_legends_app_compose.features.signup.presentation.state.SignUpUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    private val _uiEvent = Channel<LoginEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAction(action: LoginAction) {
        when(action){
            is LoginAction.EmailChanged -> {
                _uiState.update { it.copy(email = action.email) }
            }
            is LoginAction.PasswordChanged -> {
                _uiState.update { it.copy(password = action.password) }
            }
            LoginAction.onSubmit -> {
                onSubmit()
            }
        }
    }
    fun onSubmit() {
        viewModelScope.launch {
            if (_uiState.value.email.isBlank()){
                _uiState.update { it.copy(isErrorPassword = true) }
                _uiEvent.send(LoginEvent.ShowSnackbar("Email é obrigatório"))
                return@launch
            }
            if (_uiState.value.password.isBlank()){
                _uiState.update { it.copy(isErrorPassword = true) }
                _uiEvent.send(LoginEvent.ShowSnackbar("Password é obrigatório"))
                return@launch
            }
            _uiState.update { it.copy(isLoading = true) }
            withContext(Dispatchers.IO){
                delay(5000)
                val result = repository.login(_uiState.value.email, _uiState.value.password)
                result.fold(
                    onSuccess = {
                        _uiEvent.send(LoginEvent.NavigateToHome)
                        _uiEvent.send(LoginEvent.ShowSnackbar("Login efetuado com sucesso"))
                        _uiState.update { it.copy(isLoading = false) }
                    },
                    onFailure = {
                        _uiEvent.send(LoginEvent.ShowSnackbar("email ou senha incorretos"))
                        _uiState.update { it.copy(isLoading = false) }

                    }
                )
            }
        }
    }
}