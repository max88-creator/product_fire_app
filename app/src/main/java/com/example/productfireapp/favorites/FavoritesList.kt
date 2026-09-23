package com.example.productfireapp.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.productfireapp.presentation.viewmodels.HomeScreenViewModel
import com.example.productfireapp.ui.theme.BGGray

@Composable
fun FavoritesList(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 17.dp)
            .background(color = BGGray)
    ) {
        Spacer(modifier = Modifier.height(26.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
//            items(favoriteItems.value) { item ->
//
//            }
        }
    }
}