package com.example.productfireapp.payment_method

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun MonthYearTF(
    month: String,
    onMonthValueChange: (String) -> Unit,
    year: String,
    onYearValueChange: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TextField(
            value = month,
            onValueChange = { onMonthValueChange(it) },
            modifier = Modifier
                .width(187.dp)
                .height(60.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(5.dp)
                ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true
        )
        Spacer(modifier = Modifier.width(6.dp))
        TextField(
            value = year,
            onValueChange = { onYearValueChange(it) },
            modifier = Modifier
                .width(187.dp)
                .height(60.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(5.dp)
                ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true
        )
    }
}