package com.example.productfireapp.add_credit_card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.productfireapp.R
import com.example.productfireapp.ui.theme.AppFontFamily
import org.w3c.dom.Text

@Composable
@Preview(showBackground = true)
fun AddCardTopBar() {
    val space = 18.sp * 0.03f
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(118.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 17.dp, top = 68.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.back_arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .width(23.dp)
                        .height(16.dp)
                        .clickable{}
                )
            }
            Box(
                modifier = Modifier
                    .padding(top = 63.dp, start = 90.dp)
            ) {
                Text(
                    text = "Add Credit Card",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        fontSize = 18.sp,
                        fontWeight = FontWeight(500),
                        letterSpacing = space
                    )
                )
            }
        }
    }
}