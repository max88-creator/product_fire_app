package com.example.productfireapp.presentation.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.productfireapp.presentation.viewmodels.FavoritesScreenViewModel
import com.example.productfireapp.ui.theme.CustomGray

@Composable
fun FavoritesList(
    viewModel: FavoritesScreenViewModel = hiltViewModel(),
    backToHome: () -> Unit
) {
    val favoritesList = viewModel.favorites.collectAsState()
    Scaffold(
        topBar = {
            TopFavoriteBar(
                backToHomeScreenClick = {
                    backToHome()
                })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(color = CustomGray.copy(alpha = 0.2f))
        ) {
            Spacer(modifier = Modifier.height(26.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 17.dp)
            ) {
                items(favoritesList.value) { favorite ->
                   SwipeFavorite(
                       favorite,
                       onDeleteClick = { viewModel.deleteFavorite(favorite.id)}
                       )
                    Spacer(modifier = Modifier.height(14.dp))
                }
            }
        }
    }
}