package com.example.productfireapp.favorites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import com.example.productfireapp.domain.models.Favorite
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.CustomGray
import com.example.productfireapp.ui.theme.DarkPrimary

@Composable
fun FavoriteItem(
    favorite: Favorite
) {
    Box(
        modifier = Modifier
            .width(380.dp)
            .height(100.dp)
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 20.dp, top = 18.dp),
           horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(color = favorite.bgColor, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = favorite.image),
                    contentDescription = null,
                    modifier = Modifier
                        .width(50.dp)
                        .height(41.dp)
                )
            }
            Spacer(modifier = Modifier.width(22.dp))
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "$ ${favorite.coast} x ${favorite.count}",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = DarkPrimary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500)
                    )
                )
                Text(
                    text = favorite.name,
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight(600)
                    )
                )
                Text(
                    text = "$ ${favorite.weightValue} ${favorite.weightParameter}",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = CustomGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500)
                    )
                )
            }
            Spacer(modifier = Modifier.width(240.dp))
            Column(
                modifier = Modifier.background(Color.White),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "+",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = DarkPrimary,
                        fontSize = 18.sp
                    )
                )
                Text(
                    text = favorite.count.toString()
                )
                Text(
                    text = "-",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = DarkPrimary,
                        fontSize = 18.sp
                    )
                )
            }
        }
    }
}