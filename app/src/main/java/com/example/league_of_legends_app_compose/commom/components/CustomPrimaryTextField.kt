package com.example.league_of_legends_app_compose.commom.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.league_of_legends_app_compose.R
import com.example.league_of_legends_app_compose.commom.theme.LeagueOfLegendsAppComposeTheme
import com.example.league_of_legends_app_compose.commom.theme.PrimaryTextField

@Composable
fun CustomPrimaryTextFieldScreen(
    value: String,
    title: String,
    label: String? = null,
    keyboardType: KeyboardType = KeyboardType.Email,
    isError: Boolean = false,
    imeAction: ImeAction = ImeAction.Next,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    var iconVisibility by remember { mutableStateOf(false) }

    Column (modifier = modifier.fillMaxWidth()){
        Text(title, color = Color.White, fontSize = 14.sp)
        OutlinedTextField(
            value = value,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            textStyle = TextStyle(color = Color.White),
            maxLines = 1,
            isError = isError,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            onValueChange = onValueChange,
            visualTransformation = if (keyboardType == KeyboardType.Password){
                if (iconVisibility){
                    VisualTransformation.None
                }else{
                    PasswordVisualTransformation()
                }
            } else {
                VisualTransformation.None
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = PrimaryTextField,
                focusedContainerColor = PrimaryTextField,
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.White,
                errorBorderColor = Color.Red,
            ),
            trailingIcon = {
                if (keyboardType == KeyboardType.Password && value.isNotEmpty()) {
                    val icon = if (iconVisibility) {
                        R.drawable.ic_visibility_off
                    } else {
                        R.drawable.ic_visibility
                    }
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = null,
                        modifier = Modifier.clickable { iconVisibility = !iconVisibility }
                    )
                }
            },
            label = {
                if (label != null) {
                    Text(text = label, color = Color.White,fontSize = 14.sp)
                }
            }

        )
    }
}

@Preview
@Composable
private fun CustomPrimaryTextFieldPreview() {
    LeagueOfLegendsAppComposeTheme {
        CustomPrimaryTextFieldScreen(
            value = "12321",
            isError = true,
            label = "",
            keyboardType = KeyboardType.Password,
            onValueChange = {},
            title = ""
        )
    }
}