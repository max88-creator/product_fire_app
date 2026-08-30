package com.example.productfireapp.payment_method

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productfireapp.ui.theme.DarkPrimary
import com.example.productfireapp.ui.theme.MediumPrimary

@Composable
fun PaymentSwitch(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Switch(
        checked = isChecked,
        onCheckedChange = { onCheckedChange(it) },
        modifier = Modifier
//            .width(29.dp)
//            .height(16.dp)
            .size(21.dp)
        ,
        thumbContent = {
//            Box(
//                modifier = Modifier
//                    .size(15.dp)
//                    .clip(CircleShape)
//                    .background(Color.White)
//            )
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.White,
            uncheckedThumbColor = Color.White,
            checkedTrackColor = MediumPrimary,
            uncheckedTrackColor = Color.Blue
        ),
        //    interactionSource = TODO()
    )
}