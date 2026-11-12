package com.example.productfireapp.presentation.screens.filter

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.CustomGray
import com.example.productfireapp.ui.theme.TextBoxGray

@Composable
fun MinMaxTextField(
    value: String,
    labelText: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },

        modifier = Modifier
            .width(143.dp),
        label = {
            Text(
                text = labelText,
                style = TextStyle(
                    fontFamily = AppFontFamily,
                    color = CustomGray,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(500)
                )
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedTextColor = TextBoxGray,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}



