package com.example.productfireapp.presentation.screens.filter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.example.productfireapp.R
import com.example.productfireapp.presentation.screens.filter.filter_view_model.FilterViewModel
import com.example.productfireapp.ui.theme.BorderColor
import com.example.productfireapp.ui.theme.TextBoxGray

@Composable
fun SearchResultScreen(
    onFilterScreen: () -> Unit,
    viewModelStoreOwner: ViewModelStoreOwner
) {
    val filterVm = hiltViewModel<FilterViewModel>(viewModelStoreOwner = viewModelStoreOwner)
    var inputValue by remember { mutableStateOf("") }
    val vegetables = filterVm.vegetables.collectAsState()


    val searchedVegetables = if (inputValue.isNotBlank()) {
        vegetables.value.filter { vegetable ->
            vegetable.name.contains(inputValue)
        }
    } else {
        vegetables.value
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BorderColor)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 17.dp)

        )
        {
            Spacer(modifier = Modifier.height(35.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = inputValue,
                    onValueChange = {
                        inputValue = it
                    },
                    modifier = Modifier
                        .weight(1f),
                    shape = RoundedCornerShape(5.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedTextColor = TextBoxGray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )

                IconButton(
                    onClick = {
                        onFilterScreen()
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_sort),
                        contentDescription = null,
                        modifier = Modifier
                            .width(19.dp)
                            .height(17.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(35.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(searchedVegetables) { vegetable ->
                    FilterResultItem(
                        name = vegetable.name,
                        coast = vegetable.coast.toString()
                    )
                    Spacer(modifier = Modifier.height(9.dp))
                }
            }
        }
    }
}

