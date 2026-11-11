package com.example.productfireapp.filter

import androidx.compose.foundation.layout.Box
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
import com.example.productfireapp.presentation.viewmodels.HomeScreenViewModel

@Composable
fun FilterResultScreen(
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel(),
) {
    val productList = homeScreenViewModel.vegetableList.collectAsState()
    val items = productList.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 17.dp)
    ) {
        Spacer(modifier = Modifier.height(125.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(items) { item ->
                FilterResultItem(
                    name = item.name,
                    coast = item.coast.toString()
                )
                Spacer(modifier = Modifier.height(9.dp))
            }
        }
    }
}

