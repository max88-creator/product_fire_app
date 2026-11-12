package com.example.productfireapp.utils

import androidx.room.TypeConverter
import com.example.productfireapp.domain.models.Country

class ConvertCountry {
    @TypeConverter
    fun fromCountry(country: Country): String {
        return country.name
    }

    @TypeConverter
    fun toCountry(value: String): Country {
        return Country.valueOf(value)
    }
}

