package com.example.productfireapp.presentation.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.productfireapp.R



@Composable
fun HomeScreen(
    toProductListNavigate: () ->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp)
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            SearchKeyWordsBox()
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(
                    id = R.drawable.advertisiment
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(283.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            CategoryBox()
            Spacer(modifier = Modifier.height(32.dp))
            ChosenProductsColumn(
                toProductListClick = {
                    toProductListNavigate()
                }
            )
        }
    }
}


//            vegetablesList.forEach { item ->
//                Row(
//
//                ) {
//                    ProductItem(
//                        vegetable = item,
//                        onFavoriteClick = {},
//                        onAddClick = {}
//                    )
//                    Spacer(modifier = Modifier.height(18.dp))
//                }
//            }


//    val categoriesList = listOf(
//        Category(
//            image = R.drawable.category_vegeetables,
//            name = "Vegetables",
//            bgColor = BGGray,
//            modifier = Modifier
//                .width(23.dp)
//                .height(25.dp)
//        ),
//        Category(
//            image = R.drawable.category_fruits,
//            name = "Fruits",
//            bgColor = LightOrange,
//            modifier = Modifier
//                .width(21.dp)
//                .height(26.dp)
//        ),
//        Category(
//            image = R.drawable.category_beverage,
//            name = "Beverages",
//            bgColor = LightYellow,
//            modifier = Modifier
//                .width(26.dp)
//                .height(26.dp)
//        ),
//        Category(
//            image = R.drawable.category_grocery,
//            name = "Groceries",
//            bgColor = GrColor,
//            modifier = Modifier
//                .width(25.dp)
//                .height(27.dp)
//        ),
//        Category(
//            image = R.drawable.category_editable_oil,
//            name = "Editable oil",
//            bgColor = OilColor,
//            modifier = Modifier
//                .width(25.dp)
//                .height(26.dp)
//        ),
//        Category(
//            image = R.drawable.category_household,
//            name = "Household",
//            bgColor = PinkC,
//            modifier = Modifier
//                .width(31.dp)
//                .height(31.dp)
//        ),
//        Category(
//            image = R.drawable.category_baby_care,
//            name = "Babycare",
//            bgColor = LightBlue,
//            modifier = Modifier
//                .width(36.dp)
//                .height(36.dp)
//        )
//    )




