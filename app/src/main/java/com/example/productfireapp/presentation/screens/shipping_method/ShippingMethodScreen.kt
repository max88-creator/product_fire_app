package com.example.productfireapp.presentation.screens.shipping_method

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.productfireapp.R
import com.example.productfireapp.ui.theme.BorderColor

@Composable
fun ShippingMethodScreen(
    backToBasketScreenClick: () -> Unit,
    onShippingInformationClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopShippingBar(
                backToBasketScreenClick = {
                    backToBasketScreenClick()
                }
            )
        },
        bottomBar = {
            BottomShippingBar(
                onShippingInformationClick
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(color = BorderColor)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(22.dp))
                Image(
                    painter = painterResource(R.drawable.shipping_wizard),
                    contentDescription = null,
                    modifier = Modifier
                        .width(297.dp)
                        .height(61.dp)
                )
            }
            Spacer(modifier = Modifier.height(52.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 17.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                DeliveryOptionBox(
                    deliveryName = "Standard Delivery",
                    deliveryDescription = "Order will be delivered between 3 - 4 business\n" +
                            "days straights to your doorstep.",
                    coast = 3
                )
                DeliveryOptionBox(
                    deliveryName = "Next Day Delivery",
                    deliveryDescription = "Order will be delivered between 3 - 4 business\n" +
                            "days straights to your doorstep.",
                    coast = 5
                )
                DeliveryOptionBox(
                    deliveryName = "Nominated Delivery",
                    deliveryDescription = "Order will be delivered between 3 - 4 business\n" +
                            "days straights to your doorstep.",
                    coast = 3
                )
            }
        //    Spacer(modifier = Modifier.height(121.dp))
        }
    }
}