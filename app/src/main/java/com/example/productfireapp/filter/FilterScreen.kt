package com.example.productfireapp.filter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.BorderColor
import com.example.productfireapp.ui.theme.DarkPrimary

@Composable
fun FilterScreen(
    backToHomeClick: () -> Unit
) {
    var minValue by remember { mutableIntStateOf(0) }
    var maxValue by remember { mutableIntStateOf(0) }
    Scaffold(
        topBar = {
            TopFilterBar(
                backToHomeScreenClick = {
                    backToHomeClick()
                },
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(color = BorderColor)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 17.dp)
            ) {
                Spacer(modifier = Modifier.height(21.dp))
                FilterItemsCard()
                Spacer(modifier = Modifier.height(105.dp))
                Box(
                    modifier = Modifier
                        .width(380.dp)
                        .height(60.dp)
                        .background(
                            color = DarkPrimary,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .clickable {

                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Checkout",
                        style = TextStyle(
                            fontFamily = AppFontFamily,
                            color = Color.White,
                            fontSize = 15.sp,
                            fontWeight = FontWeight(600)
                        )
                    )
                }
            }
        }
    }
}