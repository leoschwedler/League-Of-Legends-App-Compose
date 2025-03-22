package com.example.league_of_legends_app_compose.features.login.presentation.ui

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.league_of_legends_app_compose.R
import com.example.league_of_legends_app_compose.commom.components.CustomPrimaryButton
import com.example.league_of_legends_app_compose.commom.components.CustomPrimaryTextFieldScreen
import com.example.league_of_legends_app_compose.commom.theme.Background
import com.example.league_of_legends_app_compose.features.login.presentation.action.LoginAction
import com.example.league_of_legends_app_compose.features.login.presentation.event.LoginEvent
import com.example.league_of_legends_app_compose.features.login.presentation.state.LoginUiState
import com.example.league_of_legends_app_compose.features.login.presentation.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    navigateToHome: () -> Unit,
    onbackPressed: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val snackBarHostState = remember { SnackbarHostState() }
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("loading.json"))

    LaunchedEffect(true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                LoginEvent.NavigateToHome -> {
                    navigateToHome()
                }

                is LoginEvent.ShowSnackbar -> {
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

        composition?.let {
            LoginContent(
                uiState = uiState,
                onAction = viewModel::onAction,
                onbackPressed = onbackPressed,
                composition = it
            )
        }
        SnackbarHost(
            hostState = snackBarHostState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
        )
    }
}

@Composable
private fun LoginContent(
    uiState: LoginUiState,
    onAction: (LoginAction) -> Unit,
    onbackPressed: () -> Unit,
    composition: LottieComposition,
) {

    Box(
        Modifier
            .fillMaxSize()
            .background(color = Background)
    ) {
        Image(
            painter = painterResource(R.drawable.login),
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
                    })
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
                    onAction(LoginAction.EmailChanged(it))
                },
                title = "Email"
            )
            Spacer(Modifier.height(16.dp))
            CustomPrimaryTextFieldScreen(
                value = uiState.password,
                isError = uiState.isErrorPassword,
                onValueChange = {
                    onAction(LoginAction.PasswordChanged(it))
                },

                title = "Senha",
                keyboardType = KeyboardType.Password
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "Esqueceu a senha?",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )
            if (uiState.isLoading){
                LottieAnimation(
                    composition = composition,
                    modifier = Modifier
                        .size(200.dp),
                    iterations = LottieConstants.IterateForever,
                    maintainOriginalImageBounds = true
                )
            }

            CustomPrimaryButton(
                title = "Entrar",
                onClick = { onAction(LoginAction.onSubmit) },
                Modifier.padding(top = 50.dp)
            )

        }
    }
}

@Preview
@Composable
private fun LoginPreview() {
    LoginScreen({}, {})
}