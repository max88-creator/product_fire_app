package com.example.productfireapp.shipping_adress.view_model

import com.example.productfireapp.domain.models.Country

sealed class ShippingAddressEvent {
    data class OnNameTextChange(val name: String): ShippingAddressEvent()
    data class OnEmailTextChange(val value: String): ShippingAddressEvent()
    data class OnPhoneNumberTextChange(val number: String): ShippingAddressEvent()
    data class OnAddressTextChange(val address: String): ShippingAddressEvent()
    data class OnZipCodeTextChange(val value: String): ShippingAddressEvent()
    data class OnCityTextChange(val value: String): ShippingAddressEvent()
    data class ChoseCountry(val country: Country): ShippingAddressEvent()
}

