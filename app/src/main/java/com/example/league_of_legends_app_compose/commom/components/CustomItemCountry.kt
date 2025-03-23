package com.example.league_of_legends_app_compose.commom.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.league_of_legends_app_compose.R
import com.example.league_of_legends_app_compose.features.home.domain.Country

@Composable
fun CustomItemCountry(
    country: Country,
    modifier: Modifier = Modifier
) {
    Column {
        Surface(
            modifier = modifier
                .height(123.dp)
                .padding(end = 5.dp)
                .width(104.dp),
            color = Color(0xFF2B2C33),
            shape = MaterialTheme.shapes.small
        ) {
            Image(
                painter = painterResource(country.image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Spacer(Modifier.height(5.dp))
        Text(text = country.country, color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
private fun CustomItemCountryPreview() {

    CustomItemCountry(
        country = Country(
            country = "Noxus",
            image = R.drawable.country2
        )

    )

}