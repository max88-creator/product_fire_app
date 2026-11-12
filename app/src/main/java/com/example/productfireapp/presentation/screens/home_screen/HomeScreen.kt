package com.example.productfireapp.presentation.screens.home_screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.productfireapp.R
import com.example.productfireapp.navigation.NavigationRoutes


@Composable
fun HomeScreen(
    toProductListNavigate: () -> Unit,
    toFilterScreenClick: () -> Unit,
    onSearchResultClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp)
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            SearchKeyWordsBox(
                onSearchResultClick = {
                    onSearchResultClick()
                },
                applyFiltersClick = {
                    toFilterScreenClick()
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(
                    id = R.drawable.advertisiment
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(283.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            CategoryBox()
            Spacer(modifier = Modifier.height(32.dp))
            ChosenProductsColumn(
                toProductListClick = {
                    toProductListNavigate()
                }
            )
        }
    }
}


