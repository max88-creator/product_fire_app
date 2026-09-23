package com.example.productfireapp.presentation.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.productfireapp.presentation.viewmodels.HomeScreenViewModel
import com.example.productfireapp.ui.theme.TextBoxGray

@Composable
fun ProductsList(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    backToHomeScreenClick: () -> Unit
) {
    val scrollState = rememberScrollState()
    val pairs = viewModel.elements.vegList.windowed(2, 2, true)
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                TopProductBar(
                    label = "Products",
                    onNavigateClick = {
                        backToHomeScreenClick()
                    }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 17.dp)
                    .background(color = TextBoxGray)
            ) {
                Spacer(modifier = Modifier.height(25.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(TextBoxGray)
                        .verticalScroll(scrollState),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    pairs.forEach { pair ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(18.dp)
                        ) {

                            pair.forEach { item ->
                                ProductItem(
                                    vegetable = item
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }
    }
}