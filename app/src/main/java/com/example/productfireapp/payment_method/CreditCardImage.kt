package com.example.productfireapp.payment_method

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.DarkPrimary
import com.example.productfireapp.ui.theme.RedCircle
import com.example.productfireapp.ui.theme.YellowCircle

@Composable
fun CreditCardImage(
    numberOnCard: String,
    nameOnCard: String,
    monthValueOnCard: String,
    yearValueOnCard: String
) {
    val letterSpace = 18.sp * 0.03f
    val middleLetterSpace = 12.sp * 0.03f
    val smallLetterSpace = 18.sp * 0.03f
    Box(
        modifier = Modifier
            .width(380.dp)
            .height(180.dp)
            .background(
                color = DarkPrimary,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Box(
            modifier = Modifier
                .padding(top = 16.dp, start = 47.dp)
                .size(34.dp)
                .background(
                    color = YellowCircle,
                    shape = CircleShape
                )
        )
        Box(
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    start = 21.dp
                )
                .size(34.dp)
                .background(
                    color = RedCircle,
                    shape = CircleShape
                )
        )
        Box(
            modifier = Modifier
                .padding(
                    top = 61.dp,
                    start = 21.dp
                )
        ) {
            Text(
                text = numberOnCard,
                style = TextStyle(
                    color = Color.White,
                    fontFamily = AppFontFamily,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(500),
                    letterSpacing = letterSpace
                )
            )
        }
        Column(
            modifier = Modifier
                .padding(
                    top = 143.dp,
                    start = 21.dp
                )
        ) {
            Text(
                text = "CARD HOLDER",
                style = TextStyle(
                    color = Color.White,
                    fontFamily = AppFontFamily,
                    fontSize = 10.sp,
                    fontWeight = FontWeight(500),
                    letterSpacing = smallLetterSpace
                )
            )
            Text(
                text = nameOnCard.uppercase(),
                style = TextStyle(
                    color = Color.White,
                    fontFamily = AppFontFamily,
                    fontSize = 10.sp,
                    fontWeight = FontWeight(500)
                )
            )
        }
        Column(
            modifier = Modifier
                .padding(
                    top = 143.dp,
                    start = 296.dp
                )
        ) {
            Text(
                text = "EXPIRES",
                style = TextStyle(
                    color = Color.White,
                    fontFamily = AppFontFamily,
                    fontSize = 10.sp,
                    fontWeight = FontWeight(500)
                )
            )
            Text(
                text = "$monthValueOnCard / $yearValueOnCard",
                style = TextStyle(
                    color = Color.White,
                    fontFamily = AppFontFamily,
                    fontSize = 10.sp,
                    fontWeight = FontWeight(500),
                    letterSpacing = middleLetterSpace
                )
            )
        }
    }
}

