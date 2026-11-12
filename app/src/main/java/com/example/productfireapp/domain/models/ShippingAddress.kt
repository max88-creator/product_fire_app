package com.example.productfireapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shipping_address")
data class ShippingAddress(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val email: String,
    val phoneNumber: String,
    val address: String,
    val zipCode: String? = null,
    val city: String,
    val country: Country
)


enum class Country {
    RUSSIA,
    GERMANY,
    TURKEY,
    GEORGIA,
    ARMENIA,
    SERBIA,
    MONTENEGRO,
    UZBEKISTAN
}

fun Country.displayName(): String {
    return when(this) {
        Country.MONTENEGRO -> "Montenegro"
        Country.ARMENIA -> "Armenia"
        Country.GEORGIA -> "Georgia"
        Country.GERMANY -> "Germany"
        Country.SERBIA -> "Serbia"
        Country.TURKEY -> "Turkey"
        Country.RUSSIA -> "Russia"
        Country.UZBEKISTAN -> "Uzbekistan"
    }
}

