package com.example.productfireapp.favorites_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.productfireapp.ui.theme.PinkC
import com.example.productfireapp.ui.theme.Purple40

@Composable
fun FavoritesList() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PinkC),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Favorites screen",
            fontSize = 35.sp
        )
    }
}