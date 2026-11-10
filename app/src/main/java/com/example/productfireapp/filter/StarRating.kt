package com.example.productfireapp.filter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.productfireapp.R
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.CustomGray
import com.example.productfireapp.ui.theme.TextBoxGray


@Composable
fun StarRating(
    selectedStars: Int,
    onStarClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 34.dp)
    ) {
        Spacer(modifier = Modifier.height(17.dp))
        Text(
            text = "Star Rating",
            style = TextStyle(
                fontFamily = AppFontFamily,
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight(600)
            )
        )
        Spacer(modifier = Modifier.height(17.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .background(
                    color = TextBoxGray,
                    shape = RoundedCornerShape(5.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 17.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(5) { index ->
                        val starNumber = index + 1
                        Image(
                            painter = painterResource(
                                if (starNumber <= selectedStars) {
                                    R.drawable.filled_star
                                } else {
                                    R.drawable.empty_star
                                }
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .width(15.dp)
                                .height(15.dp)
                                .clickable { onStarClick(starNumber) }
                        )
                    }
                }
                Text(
                    text = "$selectedStars stars",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = CustomGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500)
                    )
                )
            }
        }
    }
}