package com.example.productfireapp.presentation.home_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.productfireapp.data.Vegetable
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.MediumPrimary

@Composable
fun ChangeProductCount(
    vegetable: Vegetable,
    onDecrementClick: () -> Unit,
    onIncrementClick: () -> Unit
) {
    Spacer(modifier = Modifier.height(11.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "-",
            style = TextStyle(
                color = MediumPrimary,
                fontFamily = AppFontFamily,
                fontSize = 13.sp,
                fontWeight = FontWeight(500)
            ),
            modifier = Modifier
                .clickable {
                    onDecrementClick()
                }
        )
        Text(
            text = vegetable.count.toString(),
            style = TextStyle(
                color = MediumPrimary,
                fontFamily = AppFontFamily,
                fontSize = 12.sp,
                fontWeight = FontWeight(500)
            )
        )
        Text(
            text = "+",
            style = TextStyle(
                color = MediumPrimary,
                fontFamily = AppFontFamily,
                fontSize = 13.sp,
                fontWeight = FontWeight(500)
            ),
            modifier = Modifier
                .clickable {
                    onIncrementClick()
                }
        )
    }
}