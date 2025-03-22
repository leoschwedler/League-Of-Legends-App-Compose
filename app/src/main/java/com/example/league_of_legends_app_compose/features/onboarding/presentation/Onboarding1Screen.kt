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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import com.example.league_of_legends_app_compose.commom.theme.Background
import com.example.league_of_legends_app_compose.commom.theme.PrimaryButton
import com.example.league_of_legends_app_compose.commom.theme.SecondaryButton

@Composable
fun Onboarding1Screen(naviteToOnboarding2: () -> Unit) {
    Onboarding1Content(
        naviteToOnboarding2 = naviteToOnboarding2
    )
}

@Composable
private fun Onboarding1Content(
    naviteToOnboarding2: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Background)
    ) {
        Image(
            painter = painterResource(R.drawable.onboarding1),
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
                text = "Escolha os melhores\n" +
                        "campeões",
                color = Color.White,
                fontSize = 32.sp,
                lineHeight = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = "Os melhores campeões, builds,\n" +
                        "match-ups e tudo o que você precisa\n" +
                        "para melhorar no jogo.",
                color = Color.Gray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(20.dp))
            Surface(
                modifier = Modifier.size(56.dp),
                shape = MaterialTheme.shapes.small,
                color = SecondaryButton
            ) {

                IconButton(onClick = naviteToOnboarding2) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Onboarding1Preview() {
    Onboarding1Screen({})
}