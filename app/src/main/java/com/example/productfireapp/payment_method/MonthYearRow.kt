package com.example.productfireapp.payment_method

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.productfireapp.ui.theme.CustomGray

@Composable
fun MonthYearRow() {
    val letterSpace = 10.sp * 0.03f
    Row() {
        Box(
            modifier = Modifier
                .width(187.dp)
                .height(58.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(5.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 17.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.calendar_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(22.dp)
                )
                Spacer(modifier = Modifier.width(22.dp))
                Text(
                    text = "Month / Year",
                    style = TextStyle(
                        color = CustomGray,
                        fontFamily = AppFontFamily,
                        fontSize = 15.sp,
                        fontWeight = FontWeight(500),
                        letterSpacing = letterSpace
                    )
                )
            }
        }
    }
}