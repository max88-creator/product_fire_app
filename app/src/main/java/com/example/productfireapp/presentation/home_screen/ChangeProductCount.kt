package com.example.productfireapp.presentation.home_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.productfireapp.domain.models.Vegetable
import com.example.productfireapp.presentation.viewmodels.BasketScreenViewModel
import com.example.productfireapp.presentation.viewmodels.HomeScreenViewModel
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.MediumPrimary

@Composable
fun ChangeProductCount(
    vegetable: Vegetable,
    viewModel: HomeScreenViewModel = hiltViewModel(),
    basketItemViewModel: BasketScreenViewModel = hiltViewModel()
) {


}