package com.example.productfireapp.shipping_adress.screen

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.productfireapp.R
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.CustomGray

@Composable
fun ShippingAddressTextField(
    leadingIcon: Int,
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    val fontSize = 15
    val letterSpacing = fontSize * 0.03f
    TextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        leadingIcon = {
            Icon(painter = painterResource(leadingIcon),
                contentDescription = null,
                modifier = modifier,
                tint = CustomGray
            )
        },
        label = {
            Text(
                text = label,
                style = TextStyle(
                    fontFamily = AppFontFamily,
                    fontSize = 15.sp,
                    fontWeight = FontWeight(500),
                    color = CustomGray,
                    letterSpacing = letterSpacing.sp
                )
            )
        }
    )
}