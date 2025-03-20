package com.example.league_of_legends_app_compose.commom.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.league_of_legends_app_compose.commom.theme.PrimaryButton

@Composable
fun CustomPrimaryButton(
    title: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    ElevatedButton(
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp).height(56.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryButton
        ),
        shape = MaterialTheme.shapes.small
    ) {
        Text(title)
    }
}