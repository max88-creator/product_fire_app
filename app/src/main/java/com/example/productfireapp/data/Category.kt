package com.example.productfireapp.data


import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.productfireapp.R
import com.example.productfireapp.ui.theme.BGGray
import com.example.productfireapp.ui.theme.GrColor
import com.example.productfireapp.ui.theme.LightBlue
import com.example.productfireapp.ui.theme.LightOrange
import com.example.productfireapp.ui.theme.LightYellow
import com.example.productfireapp.ui.theme.OilColor
import com.example.productfireapp.ui.theme.PinkC

//@Entity(tableName = "category")
//data class Category(
//    @PrimaryKey(autoGenerate = true)
//    val id: Int? = null,
//    val icon: Int,
//    val name: String
//)


data class Category(
    val image: Int,
    val name: String,
    val bgColor: Color,
    val modifier: Modifier = Modifier
)

enum class CategoryE(
    val symbol: Int,
    val label: String,
    val bgColor: Color,
    val modifier1: Modifier = Modifier
) {
    VEGETABLES(
        symbol = R.drawable.category_vegeetables,
        label = "Vegetables",
        bgColor = BGGray,
        modifier1 = Modifier
            .width(23.dp)
            .height(25.dp)
    ),
    FRUITS(
        symbol = R.drawable.category_fruits,
        label = "Fruits",
        bgColor = LightOrange,
        modifier1 = Modifier
            .width(21.dp)
            .height(26.dp)
    ),
    BEVERAGES(
        symbol = R.drawable.category_beverage,
        label = "Beverages",
        bgColor = LightYellow,
        modifier1 = Modifier
            .width(26.dp)
            .height(26.dp)
    ),
    GROCERY(
        symbol = R.drawable.category_grocery,
        label = "Grocery",
        bgColor = GrColor,
        modifier1 = Modifier
            .width(25.dp)
            .height(27.dp)
    ),
    EDITABLE_OIL(
        symbol = R.drawable.category_editable_oil,
        label = "Editable oil",
        bgColor = OilColor,
        modifier1 = Modifier
            .width(25.dp)
            .height(26.dp)
    ),
    HOUSEHOLD(
        symbol = R.drawable.category_household,
        label = "Household",
        bgColor = PinkC,
        modifier1 = Modifier
            .width(31.dp)
            .height(31.dp)
    ),
    BABYCARE(
        symbol = R.drawable.category_baby_care,
        label = "Babycare",
        bgColor = LightBlue,
        modifier1 = Modifier
            .width(36.dp)
            .height(36.dp)
    )
}