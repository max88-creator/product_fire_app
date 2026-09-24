package com.example.productfireapp.payment_method.data_text_fields

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.productfireapp.R

@Composable
fun CardNumberTF(
    value: String,
    onValueChange: (String) -> Unit,
    onSaveClick: () -> Unit
) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(5.dp)
            ),
        trailingIcon = {
          IconButton(
              onClick = {
                  onSaveClick()
              }
          ) {
              Icon(
                  painter = painterResource(R.drawable.ic_check),
                  contentDescription = null
              )
          }
        },
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