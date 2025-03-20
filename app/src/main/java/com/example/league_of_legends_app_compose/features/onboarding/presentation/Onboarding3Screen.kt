package com.example.league_of_legends_app_compose.features.onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.league_of_legends_app_compose.R
import com.example.league_of_legends_app_compose.commom.components.CustomPrimaryButton
import com.example.league_of_legends_app_compose.commom.theme.Background

@Composable
fun Onboarding3Screen(navigatoToOnboarding4: () -> Unit) {
    Onboarding3Content(navigatoToOnboarding4 = navigatoToOnboarding4)
}

@Composable
private fun Onboarding3Content(navigatoToOnboarding4: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Background)
    ) {
        Image(
            painter = painterResource(R.drawable.onboarding3),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 400.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Divirta-se",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = "Seja bem-vindo ao app que vai\n" +
                        "te levar para o próximo nível \n" +
                        "no lolzinho.",
                color = Color.Gray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(50.dp))
            CustomPrimaryButton(title = "Vamos lá", onClick = navigatoToOnboarding4)

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Onboarding3Preview() {
    Onboarding3Screen({})
}