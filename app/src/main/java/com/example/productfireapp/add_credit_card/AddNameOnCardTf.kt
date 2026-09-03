package com.example.productfireapp.add_credit_card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.productfireapp.R

@Composable
fun AddNameOnCardTf(
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
            onSaveClick()
            Icon(
                painter = painterResource(
                    R.drawable.ic_check
                ),
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        ),
        singleLine = true
    )
}