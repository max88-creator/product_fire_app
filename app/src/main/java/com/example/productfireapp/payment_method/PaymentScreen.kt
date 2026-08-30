package com.example.productfireapp.payment_method

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productfireapp.R
import com.example.productfireapp.ui.theme.BorderColor

@Composable
@Preview(showBackground = true)
fun PaymentScreen() {
    Scaffold(
        topBar = {
            PayTopBar()
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .background(color = BorderColor),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(17.dp))
                    Image(
                        painter = painterResource(R.drawable.payment_chain),
                        contentDescription = null,
                        modifier = Modifier
                            .width(297.dp)
                            .height(61.dp)
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 17.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        PayPalBox()
                        CreditCardBox()
                        ApplePaymentBox()
                    }

                    CreditCartFieldsInput()
                }

            }
        }
    }
}