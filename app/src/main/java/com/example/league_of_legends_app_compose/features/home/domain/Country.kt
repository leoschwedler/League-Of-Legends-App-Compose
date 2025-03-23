package com.example.league_of_legends_app_compose.features.home.domain

import com.example.league_of_legends_app_compose.R

data class Country(
    val country: String,
    val image: Int,
)

val countries = listOf<Country>(
    Country(country = "Noxus", image = R.drawable.country2),
    Country("Shurima", R.drawable.country1),
    Country(country = "Noxus", image = R.drawable.country2),
    Country("Shurima", R.drawable.country1),
    Country(country = "Noxus", image = R.drawable.country2),
    Country("Shurima", R.drawable.country1),
    Country(country = "Noxus", image = R.drawable.country2),
    Country("Shurima", R.drawable.country1),
    Country(country = "Noxus", image = R.drawable.country2),
    Country("Shurima", R.drawable.country1),)
