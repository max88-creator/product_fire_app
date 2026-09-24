package com.example.productfireapp.basket_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.productfireapp.ui.theme.BorderColor
import com.example.productfireapp.ui.theme.CustomGray
import com.example.productfireapp.ui.theme.DarkPrimary

@Composable
fun CartBottomBar(
    onShippingMethodNavigate: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(234.dp)
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 17.dp)
        ) {
            Spacer(modifier = Modifier.height(22.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Subtotal",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = CustomGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500)
                    )
                )
                Text(
                    text = "\$56.7",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = CustomGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500)
                    )
                )
            }
            Spacer(modifier = Modifier.height(7.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Shipping charges",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = CustomGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500)
                    )
                )
                Text(
                    text = "\$1.6",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = CustomGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500)
                    )
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = BorderColor)
            )
            Spacer(modifier = Modifier.height(9.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600)
                    )
                )
                Text(
                    text = "\$58.2",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600)
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .width(380.dp)
                    .height(60.dp)
                    .background(
                        color = DarkPrimary,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .clickable {
                        onShippingMethodNavigate()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Checkout",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight(600)
                    )
                )
            }
        }
    }
}