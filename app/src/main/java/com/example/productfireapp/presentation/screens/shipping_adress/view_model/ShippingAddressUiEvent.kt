package com.example.productfireapp.presentation.screens.shipping_adress.view_model

sealed interface ShippingAddressUiEvent {
    data class ShowSnackBar(val message: String): ShippingAddressUiEvent
}