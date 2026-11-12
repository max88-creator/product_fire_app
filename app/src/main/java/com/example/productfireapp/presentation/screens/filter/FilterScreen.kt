package com.example.productfireapp.presentation.screens.filter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.productfireapp.presentation.screens.filter.filter_components.TopFilterBar
import com.example.productfireapp.presentation.screens.filter.filter_view_model.FilterScreenEvent
import com.example.productfireapp.presentation.screens.filter.filter_view_model.FilterViewModel
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.BorderColor
import com.example.productfireapp.ui.theme.DarkPrimary

@Composable
fun FilterScreen(
    backToHomeClick: () -> Unit,
    filterViewModel: FilterViewModel = hiltViewModel()
) {
    var showFilterResult by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopFilterBar(
                backToHomeScreenClick = {
                    backToHomeClick()
                },
                filterOrRefresh = showFilterResult,
                refreshClick = {
                    filterViewModel.onEvent(
                        FilterScreenEvent.OnClearFilters
                    )
                },
                returnToSort = {
                    showFilterResult = false
                },
            )
        }
    ) { paddingValues ->
        if (showFilterResult) {
            Spacer(modifier = Modifier.height(105.dp))
            FilterResultScreen()
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(color = BorderColor)
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 17.dp)
                ) {
                    Spacer(modifier = Modifier.height(21.dp))
                    FilterItemsCard(
                        minValue = filterViewModel.minValueText.value,
                        maxValue = filterViewModel.maxValueText.value,
                        discountState = filterViewModel.isExistDiscount.value,
                        freeDeliveryState = filterViewModel.isExistFreeDelivery.value,
                        sameDayDeliveryState = filterViewModel.isExistSameDayDelivery.value,
                        selectedStars = filterViewModel.selectedStars.intValue,
                        onMinValueChange = {
                            filterViewModel.onEvent(
                                FilterScreenEvent.OnMinValueTextChange(
                                    value = it
                                )
                            )
                        },
                        onMaxValueChange = {
                            filterViewModel.onEvent(
                                FilterScreenEvent.OnMaxValueTextChange(
                                    value = it
                                )
                            )
                        },
                        onDiscountClick = {
                            filterViewModel.onEvent(
                                FilterScreenEvent.OnExistDiscountClick
                            )
                        },
                        onFreeDeliveryClick = {
                            filterViewModel.onEvent(
                                FilterScreenEvent.OnFreeDeliveryClick
                            )
                        },
                        onSameDayDeliveryClick = {
                            filterViewModel.onEvent(
                                FilterScreenEvent.OnSameDayDeliveryClick
                            )
                        },
                        onStarClick = {
                            filterViewModel.onEvent(
                                FilterScreenEvent.OnStarsClick(
                                    selectedStars = it
                                )
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(105.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .background(
                                color = DarkPrimary,
                                shape = RoundedCornerShape(5.dp)
                            )
                            .clickable {
                                showFilterResult = !showFilterResult
                                filterViewModel.onEvent(
                                    FilterScreenEvent.OnApplyFilters
                                )
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Apply filter",
                            style = TextStyle(
                                fontFamily = AppFontFamily,
                                color = Color.White,
                                fontSize = 15.sp,
                                fontWeight = FontWeight(600)
                            )
                        )
                    }
                }
            }
        }
    }
}


