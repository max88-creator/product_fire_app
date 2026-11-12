package com.example.productfireapp.shipping_method

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.CustomGray
import com.example.productfireapp.ui.theme.DarkPrimary

@Composable
fun DeliveryOptionBox(
    deliveryName: String,
    deliveryDescription: String,
    coast: Int
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(116.dp)
            .background(color = Color.White)
            .padding(
                start = 17.dp, end = 17.dp,
                top = 23.dp, bottom = 23.dp
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = deliveryName,
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        fontSize = 15.sp,
                        fontWeight = FontWeight(600)
                    )
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = deliveryDescription,
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = CustomGray
                    )
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "$$coast",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        fontSize = 15.sp,
                        fontWeight = FontWeight(500),
                        color = DarkPrimary
                    )
                )
            }
        }
    }
}