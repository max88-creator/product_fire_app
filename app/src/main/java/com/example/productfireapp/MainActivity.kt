package com.example.productfireapp

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.productfireapp.first_splash_group.Splash1_1
import com.example.productfireapp.first_splash_group.Splash1_2
import com.example.productfireapp.first_splash_group.Splash1_3
import com.example.productfireapp.first_splash_group.Splash1_4
import com.example.productfireapp.payment_method.CreditCartImage
import com.example.productfireapp.payment_method.PaymentScreen
import com.example.productfireapp.ui.theme.ProductFireAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        enableEdgeToEdge()
        setContent {
            ProductFireAppTheme {
                PaymentScreen()
            }
        }
    }
}
