package com.example.productfireapp.shipping_method

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.productfireapp.R
import com.example.productfireapp.ui.theme.AppFontFamily

@Composable
fun TopShippingBar(
    backToBasketScreenClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 17.dp)
        ) {
            Spacer(modifier = Modifier.height(43.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.back_arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .width(23.dp)
                        .height(16.dp)
                        .clickable {
                            backToBasketScreenClick()
                        }
                )
                Spacer(modifier = Modifier.width(98.dp))
                Text(
                    text = "Shopping Cart",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight(500)
                    )
                )
            }
            Spacer(modifier = Modifier.height(28.dp))
        }
    }
}