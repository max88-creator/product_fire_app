package com.example.productfireapp.data.mappers

import com.example.productfireapp.domain.models.BasketItem
import com.example.productfireapp.domain.models.Favorite
import com.example.productfireapp.domain.models.Vegetable

fun Vegetable.toFavorite(): Favorite {
    return Favorite(
        id = id,
        bgColor = bgColor,
        image = image,
        coast = coast,
        count = count,
        name = name,
        weightValue = weightValue,
        weightParameter = weightParameter,
        isEventExist = isEventExist,
        eventText = eventText,
        eventTextColor = eventTextColor
    )
}

fun Vegetable.toBasketItem(): BasketItem {
    return BasketItem(
        id = id,
        bgColor = bgColor,
        image = image,
        coast = coast,
        count = count,
        name = name,
        weightValue = weightValue,
        weightParameter = weightParameter,
        isEventExist = isEventExist,
        eventText = eventText,
        eventTextColor = eventTextColor
    )
}