package com.example.productfireapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("credit_cart")
data class CreditCart(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val number: String,
    val monthYear: String,
    val cvv: String,
    val isDefault: Boolean
)


