package com.example.productfireapp.filter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.productfireapp.R
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.BorderColor
import com.example.productfireapp.ui.theme.CustomGray
import com.example.productfireapp.ui.theme.DarkPrimary

@Composable
fun OtherFilters(
    discountState: Boolean,
    freeDeliveryState: Boolean,
    sameDayDeliveryState: Boolean,
    onDiscountClick: () -> Unit,
    onFreeDeliveryClick: () -> Unit,
    onSameDayDeliveryClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 34.dp)
    ) {
        Text(
            text = "Others",
            style = TextStyle(
                fontFamily = AppFontFamily,
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight(600)
            )
        )
        Spacer(modifier = Modifier.height(18.dp))
        Row(
            modifier = Modifier
                .clickable {
                    onDiscountClick()
                }
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_discount),
                    contentDescription = null,
                    modifier = Modifier
                        .size(14.dp),
                    tint = CustomGray
                )
                Spacer(modifier = Modifier.width(36.dp))
                Text(
                    text = "Discount",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = CustomGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500)
                    )
                )
            }
            Icon(
                painter = painterResource(R.drawable.filter_checkbox),
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp),
                tint = if (discountState) {
                    DarkPrimary
                } else {
                    CustomGray
                }
            )
        }
        Spacer(modifier = Modifier.height(13.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(BorderColor)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .clickable {
                    onFreeDeliveryClick()
                }
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_delivery),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = CustomGray
                )
                Spacer(modifier = Modifier.width(36.dp))
                Text(
                    text = "Free shipping",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = CustomGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500)
                    )
                )
            }
            Icon(
                painter = painterResource(R.drawable.filter_checkbox),
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp),
                tint = if (freeDeliveryState) {
                    DarkPrimary
                } else {
                    CustomGray
                }
            )
        }
        Spacer(modifier = Modifier.height(14.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(BorderColor)
        )
        Spacer(modifier = Modifier.height(14.dp))
        Row(
            modifier = Modifier
                .clickable {
                    onSameDayDeliveryClick()
                }
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_day_delivery),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = CustomGray
                )
                Spacer(modifier = Modifier.width(36.dp))
                Text(
                    text = "Same day delivery",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = CustomGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500)
                    )
                )
            }
            Icon(
                painter = painterResource(R.drawable.filter_checkbox),
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp),
                tint = if (sameDayDeliveryState) {
                    DarkPrimary
                } else {
                    CustomGray
                }
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}