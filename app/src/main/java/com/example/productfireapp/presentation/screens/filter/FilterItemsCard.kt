package com.example.productfireapp.presentation.screens.filter

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
    minValue: String,
    maxValue: String,
    discountState: Boolean,
    freeDeliveryState: Boolean,
    sameDayDeliveryState: Boolean,
    selectedStars: Int,
    onMinValueChange: (String) -> Unit,
    onMaxValueChange: (String) -> Unit,
    onDiscountClick: () -> Unit,
    onFreeDeliveryClick: () -> Unit,
    onSameDayDeliveryClick: () -> Unit,
    onStarClick: (Int) -> Unit
) {
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
                        onMinValueChange(it)
                    }
                )
                Spacer(modifier = Modifier.width(7.dp))
                MinMaxTextField(
                    value = maxValue,
                    labelText = "Max.",
                    onValueChange = {
                        onMaxValueChange(it)
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
            onStarClick = onStarClick
        )

        Spacer(modifier = Modifier.height(28.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(BorderColor)
        )
        Spacer(modifier = Modifier.height(18.dp))
        OtherFilters(
            discountState = discountState,
            freeDeliveryState = freeDeliveryState,
            sameDayDeliveryState = sameDayDeliveryState,
            onDiscountClick = { onDiscountClick() },
            onFreeDeliveryClick = { onFreeDeliveryClick() },
            onSameDayDeliveryClick = { onSameDayDeliveryClick() }
        )
    }
}

