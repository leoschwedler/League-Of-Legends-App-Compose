package com.example.league_of_legends_app_compose.features.splash.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.league_of_legends_app_compose.R
import com.example.league_of_legends_app_compose.commom.theme.LeagueOfLegendsAppComposeTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(naviteToOnboarding1: () -> Unit) {
    LaunchedEffect (Unit){
        delay(5000)
        naviteToOnboarding1()
    }

    SplashContent()
}
@Composable
private fun SplashContent() {

    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("loading.json"))


    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.size(140.dp)
        )
        Spacer(Modifier.height(150.dp))

        LottieAnimation(
            composition = composition,
            modifier = Modifier
                .size(200.dp),
            iterations = LottieConstants.IterateForever,
            maintainOriginalImageBounds = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashPreview() {
    LeagueOfLegendsAppComposeTheme {
        SplashScreen({})
    }
}