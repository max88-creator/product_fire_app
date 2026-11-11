package com.example.productfireapp.filter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.Rusty1

@Composable
fun FilterResultItem(
name: String,
coast: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Rusty1.copy(alpha = 0.5f),
                shape = RoundedCornerShape(12.dp)
                )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(17.dp)
        ) {

            Row(

            ) {
                Text(
                    text = "Name: ",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500)
                    )
                )
                Text(
                    text = name,
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600)
                    )
                )
            }
            Spacer(modifier = Modifier.height(17.dp))
            Row(

            ) {
                Text(
                    text = "Coast: ",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500)
                    )
                )
                Text(
                    text = coast,
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600)
                    )
                )
            }
        }
    }
}


