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
import androidx.compose.foundation.layout.size
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
import com.example.league_of_legends_app_compose.commom.components.CustomSecondaryButton
import com.example.league_of_legends_app_compose.commom.theme.Background

@Composable
fun Onboarding4Screen() {
    Onboarding4Content()
}

@Composable
private fun Onboarding4Content() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Background)
    ) {
        Image(
            painter = painterResource(R.drawable.onboarding4),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(Modifier.height(100.dp))
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(90.dp)
            )
            Text(
                modifier = Modifier.padding(top = 20.dp),
                text = "Escolha os\n campeões certos",
                color = Color.White,
                lineHeight = 30.sp,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = "Escolha melhor seus campeões e suba de\nelo mais rápido",
                color = Color.Gray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(20.dp))
            CustomPrimaryButton(title = "Inscreva-se gratuitamente")
            Spacer(Modifier.height(10.dp))
            CustomSecondaryButton(icone = R.drawable.ic_google, title = "Continuar com o Google")
            Spacer(Modifier.height(10.dp))
            CustomSecondaryButton(icone = R.drawable.ic_riot, title = "Continuar com a Riot")
            Spacer(Modifier.height(30.dp))
            Text("Entrar", color = Color.White, fontWeight = FontWeight.Bold)

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Onboarding4Preview() {
    Onboarding4Screen()
}