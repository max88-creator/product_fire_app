package com.example.productfireapp.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.productfireapp.R
import com.example.productfireapp.data.Category
import com.example.productfireapp.data.Vegetable
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.AvocadoColor
import com.example.productfireapp.ui.theme.BGGray
import com.example.productfireapp.ui.theme.CustomGray
import com.example.productfireapp.ui.theme.GrColor
import com.example.productfireapp.ui.theme.GrapesColor
import com.example.productfireapp.ui.theme.LightBlue
import com.example.productfireapp.ui.theme.LightGray
import com.example.productfireapp.ui.theme.LightOrange
import com.example.productfireapp.ui.theme.LightYellow
import com.example.productfireapp.ui.theme.OilColor
import com.example.productfireapp.ui.theme.PeachColor
import com.example.productfireapp.ui.theme.PineapleColor
import com.example.productfireapp.ui.theme.PinkC
import com.example.productfireapp.ui.theme.PomegranateColor

@Composable
@Preview(showBackground = true)
fun HomeScreen() {
    val categoriesList = listOf(
        Category(
            image = R.drawable.category_vegeetables,
            name = "Vegetables",
            bgColor = BGGray,
            modifier = Modifier
                .width(23.dp)
                .height(25.dp)
        ),
        Category(
            image = R.drawable.category_fruits,
            name = "Fruits",
            bgColor = LightOrange,
            modifier = Modifier
                .width(21.dp)
                .height(26.dp)
        ),
        Category(
            image = R.drawable.category_beverage,
            name = "Beverages",
            bgColor = LightYellow,
            modifier = Modifier
                .width(26.dp)
                .height(26.dp)
        ),
        Category(
            image = R.drawable.category_grocery,
            name = "Groceries",
            bgColor = GrColor,
            modifier = Modifier
                .width(25.dp)
                .height(27.dp)
        ),
        Category(
            image = R.drawable.category_editable_oil,
            name = "Editable oil",
            bgColor = OilColor,
            modifier = Modifier
                .width(25.dp)
                .height(26.dp)
        ),
        Category(
            image = R.drawable.category_household,
            name = "Household",
            bgColor = PinkC,
            modifier = Modifier
                .width(31.dp)
                .height(31.dp)
        ),
        Category(
            image = R.drawable.category_baby_care,
            name = "Babycare",
            bgColor = LightBlue,
            modifier = Modifier
                .width(36.dp)
                .height(36.dp)
        )
    )
    val vegetablesList = listOf(
        Vegetable(
            bgColor = PeachColor,
            image = R.drawable.peach,
            coast = 0.0,
            name = "Fresh Peach",
            weight = "dozen",
            isAdded = false,
            isFavorite = false,
            isEventExist = false
        ),
        Vegetable(
            bgColor = AvocadoColor,
            image = R.drawable.avocado,
            coast = 0.0,
            name = "Avocado",
            weight = "2.0 lbs",
            isAdded = false,
            isFavorite = false,
            isEventExist = false
        ),
        Vegetable(
            bgColor = PineapleColor,
            image = R.drawable.pineapple,
            coast = 0.0,
            name = "Pineapple",
            weight = "1.50 lbs",
            isAdded = false,
            isFavorite = false,
            isEventExist = false
        ),
        Vegetable(
            bgColor = GrapesColor,
            image = R.drawable.grapes,
            coast = 0.0,
            name = "Black Grapes",
            weight = "5.0 lbs",
            isAdded = false,
            isFavorite = false,
            isEventExist = false
        ),
        Vegetable(
            bgColor = PomegranateColor,
            image = R.drawable.pomegranate,
            coast = 0.0,
            name = "Pomegranate",
            weight = "1.50 lbs",
            isAdded = false,
            isFavorite = false,
            isEventExist = false
        ),
    )
    Scaffold(

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(paddingValues)
                .padding(horizontal = 17.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(51.dp))
            SearchKeyWordsBox()
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(
                    R.drawable.advertisiment
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(283.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Categories",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600)
                    ),
                    modifier = Modifier
                        .weight(1f)
                )
                Image(
                    painter = painterResource(R.drawable.forward_arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .width(11.dp)
                        .height(18.dp)
                        .clickable {}
                )
            }
            Spacer(modifier = Modifier.height(17.dp))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(categoriesList) { item ->
                    Column(
                        modifier = Modifier
                            .width(58.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(52.dp)
                                .background(
                                    color = item.bgColor,
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(item.image),
                                contentDescription = null,
                                modifier = item.modifier
                            )
                        }
                        Spacer(modifier = Modifier.height(11.dp))
                        Text(
                            text = item.name,
                            style = TextStyle(
                                fontFamily = AppFontFamily,
                                color = CustomGray,
                                fontSize = 10.sp,
                                fontWeight = FontWeight(500)
                            )
                        )
                    }
                    Spacer(modifier = Modifier.width(19.dp))
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Featured products",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600)
                    ),
                    modifier = Modifier
                        .weight(1f)
                )
                Image(
                    painter = painterResource(R.drawable.forward_arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .width(11.dp)
                        .height(18.dp)
                        .clickable {}
                )
            }
            Spacer(modifier = Modifier.height(21.dp))
            Column(
                modifier = Modifier
                    .background(LightGray)
            ) {
                vegetablesList.forEach { item ->
                   Row(

                   ) {
                       ProductItem(
                           vegetable = item,
                           onFavoriteClick = {},
                           onAddClick = {}
                       )
                       Spacer(modifier = Modifier.height(18.dp))
                   }
                }
            }


//            LazyVerticalGrid(
//                columns = GridCells.Fixed(2),
//                modifier = Modifier,
//              //      .fillMaxSize(),
//                contentPadding = PaddingValues(
//                    horizontal = 18.dp,
//                    vertical = 20.dp
//                )
//            ) {
//                items(vegetablesList) { item ->
//                  ProductItem(
//                      vegetable = item,
//                      onFavoriteClick = {},
//                      onAddClick = {}
//                  )
//                }
//            }

        }
    }
}

