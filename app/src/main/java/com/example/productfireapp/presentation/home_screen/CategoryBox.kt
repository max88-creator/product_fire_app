package com.example.productfireapp.presentation.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.productfireapp.R
import com.example.productfireapp.presentation.viewmodels.HomeScreenViewModel
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.CustomGray
import kotlinx.coroutines.launch

@Composable
@Preview(showBackground = true)
fun CategoryBox(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center
    ) {
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
                    .clickable {
                        coroutineScope.launch {
                            val current = listState.firstVisibleItemIndex
                            if (current < viewModel.elements.categoryItem.lastIndex) {
                                listState.animateScrollToItem(index = current + 1)
                            }
                        }
                    }
            )
        }
        Spacer(modifier = Modifier.height(17.dp))
        LazyRow(
            state = listState,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(viewModel.elements.categoryItem) { item ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),

                    horizontalAlignment = Alignment.CenterHorizontally
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
                            painter = painterResource(item.symbol),
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(11.dp))
                    Text(
                        text = item.label,
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
    }
}
