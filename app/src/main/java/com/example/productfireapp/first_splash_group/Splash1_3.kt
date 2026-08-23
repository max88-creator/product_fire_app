package com.example.productfireapp.first_splash_group

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.productfireapp.R
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.BorderColor
import com.example.productfireapp.ui.theme.CustomGray

@Composable
@Preview(showBackground = true)
fun Splash1_3() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = BorderColor)
        ) {
            Image(
                painter = painterResource(R.drawable.splash_1_3),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .offset(x = (0).dp, y = (-31).dp),
                contentScale = ContentScale.FillHeight
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 17.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(84.dp))
                Text(
                    text = "Buy Premium",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        fontSize = 30.sp,
                        fontWeight = FontWeight(700),
                        lineHeight = 39.sp,
                        letterSpacing = 0.9.sp
                    )
                )
                Text(
                    text = "Quality Fruits",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        fontSize = 30.sp,
                        fontWeight = FontWeight(700),
                        lineHeight = 39.sp,
                        letterSpacing = 0.9.sp
                    )
                )
                Spacer(modifier = Modifier.height(17.dp))
                Text(
                    text = "Lorem ipsum dolor sit amet, consetetur",
                    style = TextStyle(
                        color = CustomGray,
                        fontFamily = AppFontFamily,
                        fontSize = 15.sp,
                        fontWeight = FontWeight(500),

                        letterSpacing = 0.9.sp
                    )
                )
                Text(
                    text = "sadipscing elitr, sed diam nonumy",
                    style = TextStyle(
                        color = CustomGray,
                        fontFamily = AppFontFamily,
                        fontSize = 15.sp,
                        fontWeight = FontWeight(500),
                        letterSpacing = 0.9.sp
                    )
                )
                Spacer(modifier = Modifier.height(441.dp))
                Row() {
                    NavigationDot(false)
                    Spacer(modifier = Modifier.width(5.dp))
                    NavigationDot(false)
                    Spacer(modifier = Modifier.width(5.dp))
                    NavigationDot(true)
                    Spacer(modifier = Modifier.width(5.dp))
                    NavigationDot(false)
                }
                Spacer(modifier = Modifier.height(32.dp))
                GetStartButton()
            }
        }
    }
}