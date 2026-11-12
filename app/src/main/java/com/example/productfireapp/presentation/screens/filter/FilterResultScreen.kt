package com.example.productfireapp.presentation.screens.filter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.productfireapp.presentation.screens.filter.filter_view_model.FilterViewModel

@Composable
fun FilterResultScreen(
) {
    val filterViewModel = hiltViewModel<FilterViewModel>()

    val state = filterViewModel.filterUiState.collectAsState()

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
            items(state.value.getFilteredVegetables) { item ->
                FilterResultItem(
                    name = item.name,
                    coast = item.coast.toString()
                )
                Spacer(modifier = Modifier.height(9.dp))
            }
        }
    }
}

