package com.example.productfireapp.home_screen

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.productfireapp.data.Vegetable
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.BGGray
import com.example.productfireapp.ui.theme.BorderColor
import com.example.productfireapp.ui.theme.CustomGray
import com.example.productfireapp.ui.theme.MediumPrimary

@Composable
fun ProductItem(
    vegetable: Vegetable,
    onFavoriteClick: () -> Unit,
    onAddClick: () -> Unit
) {
    val space = 10.sp * 0.05f
    Box(
        modifier = Modifier
            .width(181.dp)
            .height(234.dp)
            .background(color = Color.White)
    ) {
        if (vegetable.isEventExist) {
            Box(
                modifier = Modifier
                    .width(38.dp)
                    .height(18.dp)
                    .background(vegetable.bgColor)
                    .align(Alignment.TopStart),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = vegetable.eventText,
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = vegetable.eventTextColor,
                        fontSize = 10.sp,
                        fontWeight = FontWeight(500),
                        letterSpacing = space
                    )
                )
            }
        } else {
            Box(
                modifier = Modifier
                    .padding(9.dp)
                    .align(Alignment.TopEnd)
            ) {
                if (vegetable.isFavorite) {
                    Image(
                        painter = painterResource(R.drawable.heart_fill),
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            onFavoriteClick()
                        }
                    )
                } else {
                    IconButton(
                        onClick = {
                            onFavoriteClick()
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.empty_heart),
                            contentDescription = null
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 21.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                ) {
                    Box(
                        modifier = Modifier
                            .size(84.dp)
                            .background(
                                color = vegetable.bgColor,
                                shape = CircleShape
                            )
                    )
                    Image(
                        painter = painterResource(vegetable.image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(43.dp)
                            .align(Alignment.BottomCenter)
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "$${vegetable.coast}",
                    style = TextStyle(
                        color = MediumPrimary,
                        fontFamily = AppFontFamily,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500)
                    )
                )
                Text(
                    text = vegetable.name,
                    style = TextStyle(
                        color = Color.Black,
                        fontFamily = AppFontFamily,
                        fontSize = 15.sp,
                        fontWeight = FontWeight(600)
                    )
                )
                Text(
                    text = vegetable.weight,
                    style = TextStyle(
                        color = CustomGray,
                        fontFamily = AppFontFamily,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500)
                    )
                )
                Spacer(modifier = Modifier.height(11.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(BorderColor)
                )
                if (vegetable.isAdded) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            text = "-",
                            style = TextStyle(
                                color = MediumPrimary,
                                fontFamily = AppFontFamily,
                                fontSize = 13.sp,
                                fontWeight = FontWeight(500)
                            ),
                            modifier = Modifier
                                    .clickable {
                                        if (vegetable.count == 1) {
                                            vegetable.isAdded = false
                                        } else {
                                            vegetable.count--
                                        }
                                    }
                        )
                        Text(
                            text = vegetable.count.toString(),
                            style = TextStyle(
                                color = MediumPrimary,
                                fontFamily = AppFontFamily,
                                fontSize = 12.sp,
                                fontWeight = FontWeight(500)
                            )
                        )
                        Text(
                            text = "+",
                            style = TextStyle(
                                color = MediumPrimary,
                                fontFamily = AppFontFamily,
                                fontSize = 13.sp,
                                fontWeight = FontWeight(500)
                            ),
                            modifier = Modifier
                                .clickable{
                                    vegetable.count++
                                }
                        )
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.green_basket),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(13.dp)
                                    .height(15.dp)
                            )
                            Spacer(modifier = Modifier.width(9.dp))
                            Text(
                                text = "Add to cart",
                                style = TextStyle(
                                    color = CustomGray,
                                    fontFamily = AppFontFamily,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(500)
                                ),
                                modifier = Modifier
                                    .clickable {
                                        onAddClick()
                                    }
                            )
                        }
                    }
                }
            }
        }
    }
}
