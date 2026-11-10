package com.example.productfireapp.filter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.BorderColor

@Composable
fun FilterItemsCard(

) {
    var minValue by remember { mutableStateOf("") }
    var maxValue by remember { mutableStateOf("") }
    var selectedStars by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 34.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Price Range",
                style = TextStyle(
                    fontFamily = AppFontFamily,
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight(600)
                )
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                MinMaxTextField(
                    value = minValue,
                    labelText = "Min.",
                    onValueChange = {
                        minValue = it
                    }
                )
                Spacer(modifier = Modifier.width(7.dp))
                MinMaxTextField(
                    value = maxValue,
                    labelText = "Max.",
                    onValueChange = {
                        maxValue = it
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(BorderColor)
        )
        StarRating(
            selectedStars = selectedStars,
            onStarClick = { selectedStars = it }
        )

        Spacer(modifier = Modifier.height(28.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(BorderColor)
        )
        Spacer(modifier = Modifier.height(18.dp))
        OtherFilters()
    }
}

