package com.example.productfireapp.presentation.screens.shipping_adress.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.productfireapp.domain.models.Country
import com.example.productfireapp.domain.models.displayName
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.ArrowDownColor
import com.example.productfireapp.ui.theme.CustomGray

@Composable
fun CountryTextField(
    selectedCountry: Country,
    onExpandedClick: () -> Unit
) {
    val fontSize = 15
    val letterSpacing = fontSize * 0.03f
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                Row() {
                    Icon(
                        painter = painterResource(R.drawable.ic_country),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp),
                        tint = CustomGray
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = selectedCountry.displayName(),
                        style = TextStyle(
                            fontFamily = AppFontFamily,
                            fontSize = 15.sp,
                            fontWeight = FontWeight(500),
                            color = CustomGray,
                            letterSpacing = letterSpacing.sp
                        )
                    )
                }
            }
            Icon(
                painter = painterResource(R.drawable.arrow_down),
                contentDescription = null,
                modifier = Modifier
                    .width(14.dp)
                    .height(11.dp)
                    .clickable {
                        onExpandedClick()
                    },
                tint = ArrowDownColor
            )
        }
    }
}
