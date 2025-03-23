package com.example.league_of_legends_app_compose.features.home.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.league_of_legends_app_compose.R
import com.example.league_of_legends_app_compose.commom.components.CustomItemChampion
import com.example.league_of_legends_app_compose.commom.components.CustomItemCountry
import com.example.league_of_legends_app_compose.commom.theme.Background
import com.example.league_of_legends_app_compose.features.home.domain.Champion
import com.example.league_of_legends_app_compose.features.home.domain.Country
import com.example.league_of_legends_app_compose.features.home.domain.champions
import com.example.league_of_legends_app_compose.features.home.domain.countries

@Composable
fun HomeScreen() {
    HomeContent(
        listCountry = countries,
        listChampion = champions
    )
}

@Composable
private fun HomeContent(
    listCountry: List<Country>,
    listChampion: List<Champion>,
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xFF101114))
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 60.dp
                )
                .verticalScroll(rememberScrollState())
        ) {
            Row {
                Image(
                    painter = painterResource(R.drawable.perfil),
                    contentDescription = null,
                    Modifier.size(80.dp)
                )
                Spacer(Modifier.width(12.dp))
                Column {
                    Text(
                        text = "LEOSCHWEDLER",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = "Super Idol的笑容 都没你的甜",
                        fontSize = 12.sp,
                        color = Color(0xFFB3B0B8)
                    )
                }
                Spacer(Modifier.weight(1f))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.ic_search),
                        contentDescription = null,
                        Modifier.size(24.dp)
                    )
                    Spacer(Modifier.width(7.dp))
                    Image(
                        painter = painterResource(R.drawable.elo),
                        contentDescription = null,
                        Modifier.size(50.dp),
                        contentScale = ContentScale.Crop
                    )
                }

            }
            Spacer(Modifier.height(32.dp))
            Text(
                text = "Meus campeões",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(24.dp))
            LazyRow(
                Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 200.dp)
            ) {
                items(listChampion) {
                    CustomItemChampion(champion = it)
                }
            }

            Text(
                text = "Recomendados para você",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(R.drawable.recomendation),
                contentDescription = null,
                Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(32.dp))
            Text(
                text = "Runeterra",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(24.dp))
            LazyRow(
                Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 200.dp)
            ) {
                items(listCountry) { country ->
                    CustomItemCountry(country = country)
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomePreview() {
    HomeScreen()
}