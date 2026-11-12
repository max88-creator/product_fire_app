package com.example.productfireapp.shipping_adress.view_model

import com.example.productfireapp.domain.models.Country

data class ShippingAddressUiState(
    val nameText: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val address: String = "",
    val zipCode: String = "",
    val city: String = "",
    val country: Country = Country.RUSSIA
)

