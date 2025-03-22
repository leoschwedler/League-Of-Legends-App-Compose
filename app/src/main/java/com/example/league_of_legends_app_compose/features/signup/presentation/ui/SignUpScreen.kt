package com.example.league_of_legends_app_compose.features.signup.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.league_of_legends_app_compose.R
import com.example.league_of_legends_app_compose.commom.components.CustomPrimaryButton
import com.example.league_of_legends_app_compose.commom.components.CustomPrimaryTextFieldScreen
import com.example.league_of_legends_app_compose.commom.theme.Background
import com.example.league_of_legends_app_compose.features.signup.presentation.action.SignUpAction
import com.example.league_of_legends_app_compose.features.signup.presentation.event.SignUpEvent
import com.example.league_of_legends_app_compose.features.signup.presentation.state.SignUpUiState
import com.example.league_of_legends_app_compose.features.signup.presentation.viewmodel.SignUpViewModel

@Composable
fun SignUpScreen(
    navigateToHome: () -> Unit,
    onbackPressed: () -> Unit,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val uiState by viewModel.state.collectAsState()
    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                SignUpEvent.NavigateToHome -> {
                    navigateToHome()
                }
                is SignUpEvent.ShowSnackbar -> {
                    snackBarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        SignUpContent(
            uiState = uiState,
            onAction = viewModel::onAction,
            onbackPressed = onbackPressed
        )


        SnackbarHost(
            hostState = snackBarHostState,
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 32.dp)
        )
    }
}

@Composable
fun SignUpContent(
    onbackPressed: () -> Unit,
    uiState: SignUpUiState,
    onAction: (SignUpAction) -> Unit,
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(color = Background)
    ) {
        Image(
            painter = painterResource(R.drawable.create_account),
            contentDescription = null,
            Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier.padding(start = 16.dp, top = 32.dp)) {
            Image(
                painter = painterResource(R.drawable.arrow_right),
                contentDescription = null,

                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        onbackPressed()
                    }
            )
        }

        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(180.dp))
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                Modifier.size(90.dp)
            )
            Spacer(Modifier.height(48.dp))
            CustomPrimaryTextFieldScreen(
                value = uiState.email,
                isError = uiState.isErrorEmail,
                onValueChange = {
                    onAction(SignUpAction.onEmailChanged(it))
                },
                title = "Email"
            )
            Spacer(Modifier.height(16.dp))
            CustomPrimaryTextFieldScreen(
                value = uiState.username,
                onValueChange = {
                    onAction(SignUpAction.onUsernameChanged(it))
                },
                isError = uiState.isErrorUsername,
                title = "Usuario"
            )
            Spacer(Modifier.height(16.dp))
            CustomPrimaryTextFieldScreen(
                value = uiState.password,
                keyboardType = KeyboardType.Password,
                onValueChange = {
                    onAction(SignUpAction.onPasswordChanged(it))
                },
                isError = uiState.isErrorPassword,
                title = "Senha"
            )
            Spacer(Modifier.height(16.dp))
            CustomPrimaryTextFieldScreen(
                value = uiState.repeatPassword,
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password,
                onValueChange = {
                    onAction(SignUpAction.onRepeatPasswordChanged(it))
                },
                isError = uiState.isErrorRepeatPassword,
                title = "Repita a Senha"
            )
            Spacer(Modifier.height(24.dp))
            CustomPrimaryButton(title = "Criar sua conta", onClick = {
                onAction(SignUpAction.Submit)
            })
        }
    }
}

@Preview
@Composable
private fun SignUpPreview() {
    SignUpScreen({}, {})
}