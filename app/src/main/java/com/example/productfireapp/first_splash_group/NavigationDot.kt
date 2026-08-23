package com.example.productfireapp.first_splash_group

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.productfireapp.ui.theme.DarkPrimary
import com.example.productfireapp.ui.theme.LightGray

@Composable
fun NavigationDot(
    isCurrentPage: Boolean
) {
    Box(
        modifier = Modifier
            .size(8.dp)
            .background(
                color = if (isCurrentPage) {
                    DarkPrimary
                } else {
                    LightGray
                },
                shape = CircleShape
            )
    )
}