package com.example.productfireapp.presentation.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.productfireapp.R
import com.example.productfireapp.presentation.viewmodels.HomeScreenViewModel
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.TextBoxGray

@Composable
fun ChosenProductsColumn(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    toProductListClick: () -> Unit
) {
    val items = viewModel.vegetableList.collectAsState(emptyList())

    LaunchedEffect(true) {
        viewModel.getVegCount()
    }
    val scrollState = rememberScrollState()
    val pairs = items.value.windowed(2, 2, true)

    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp),
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
                    .clickable {
                        toProductListClick()
                    }
            )
        }
        Spacer(modifier = Modifier.height(21.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(TextBoxGray)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            pairs.forEach { pair ->

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(18.dp)
                ) {

                    pair.forEach { item ->

                        ProductItem(
                            vegetable = item,

                            onDecrementClick = {
                                viewModel.decrementCount(vegetable = item)
                            },

                            onIncrementClick = {
                                viewModel.incrementItem(vegetable = item)
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

