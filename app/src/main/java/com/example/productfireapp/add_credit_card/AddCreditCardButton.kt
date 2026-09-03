package com.example.productfireapp.add_credit_card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.MediumPrimary

@Composable
fun AddCreditCardButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(
                color = MediumPrimary,
                shape = RoundedCornerShape(5.dp))
            .clickable{

            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Add credit card",
            style = TextStyle(
                fontFamily = AppFontFamily,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight(600)
            )
        )
    }
}