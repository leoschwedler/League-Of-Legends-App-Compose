package com.example.league_of_legends_app_compose.commom.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.league_of_legends_app_compose.R

@Composable
fun CustomSecondaryButton(
    icone: Int,
    title: String,
    modifier: Modifier = Modifier
) {
    ElevatedButton(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(56.dp),
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1E1F24),
        ),
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = painterResource(icone), contentDescription = null, modifier = Modifier.size(24.dp))
            Spacer(Modifier.width(50.dp))
            Text(title)
        }
    }
}

@Preview
@Composable
private fun CustomSecondaryPreview() {
    CustomSecondaryButton(
        icone = R.drawable.ic_riot,
        title = "Continuar com a Riot"
    )
}