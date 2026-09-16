package com.example.productfireapp.payment_method

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productfireapp.ui.theme.CustomGray
import com.example.productfireapp.ui.theme.MediumPrimary


@Composable
@Preview(showBackground = true)
fun CustomSwitch() {
    val startOffset = 0
    val endOffset = 13

    var boxState by remember { mutableIntStateOf(startOffset) }
    val offset by animateDpAsState(targetValue = boxState.dp)

    var isClicked by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .width(29.dp)
            .height(16.dp)

            .clickable(
                onClick = {
                    isClicked = !isClicked
                    boxState = if (isClicked) {
                        endOffset
                    } else {
                        startOffset
                    }
                }
            )
            .background(
                color = if (isClicked) {
                    MediumPrimary
                } else {
                    CustomGray
                },
                shape = RoundedCornerShape(7.dp)
            )
    ) {
        Box(
            modifier = Modifier
                .padding(start = offset)
                .size(16.dp)
                .background(
                    color = Color.White,
                    shape = CircleShape
                )
        )
    }
}
