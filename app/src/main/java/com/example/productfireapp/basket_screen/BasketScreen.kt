package com.example.productfireapp.basket_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.productfireapp.presentation.viewmodels.BasketScreenViewModel
import com.example.productfireapp.ui.theme.CustomGray

@Composable
fun BasketScreen(
    basketItemViewModel: BasketScreenViewModel = hiltViewModel(),
    backClick: () -> Unit
) {
    val items = basketItemViewModel.basketItems.collectAsState()
    Scaffold(
        topBar = {
            CartTopBar(
                backToHomeScreenClick = {
                    backClick()
                }
            )
        },
        bottomBar = {
            CartBottomBar(
                onShippingMethodNavigate = {

                }
            )
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
               items(items.value) { item ->
                   SwipeItem(
                       basketItem = item,
                       onDeleteClick = {
                           basketItemViewModel.delete(item.id)
                       }
                   )
                   Spacer(modifier = Modifier.height(14.dp))
               }
            }
        }
    }
}