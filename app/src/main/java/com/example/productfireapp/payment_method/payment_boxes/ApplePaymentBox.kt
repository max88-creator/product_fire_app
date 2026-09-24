package com.example.productfireapp.payment_method.payment_boxes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import com.example.productfireapp.ui.theme.CustomGray

@Composable
fun ApplePaymentBox() {
    val letterSpace = 10.sp * 0.03f

    Box(
        modifier = Modifier
            .width(106.dp)
            .height(98.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(5.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.apple_icon),
                contentDescription = null,
                modifier = Modifier
                    .width(22.dp)
                    .height(27.dp),
                tint = CustomGray
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Apple pay",
                style = TextStyle(
                    color = CustomGray,
                    fontSize = 10.sp,
                    fontWeight = FontWeight(500),
                    letterSpacing = letterSpace
                )
            )
        }
    }
}