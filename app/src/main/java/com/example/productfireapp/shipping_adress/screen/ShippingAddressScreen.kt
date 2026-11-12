package com.example.productfireapp.shipping_adress.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.productfireapp.R
import com.example.productfireapp.domain.models.Country
import com.example.productfireapp.domain.models.ShippingAddress
import com.example.productfireapp.domain.models.displayName
import com.example.productfireapp.shipping_adress.view_model.ShippingAddressEvent
import com.example.productfireapp.shipping_adress.view_model.ShippingAddressViewModel
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.CustomGray

@Composable
fun ShippingAddressScreen(
    shippingAddressViewModel: ShippingAddressViewModel = hiltViewModel(),
    onPaymentMethodClick: () -> Unit,
    backToShippingMethodScreenClick: () -> Unit
) {

    val state = shippingAddressViewModel.shippingAddressUiState.collectAsState()

    val item = state.value

    var expanded by remember { mutableStateOf(false) }

    val fontSize = 12
    val letterSpacing = fontSize * 0.03f

    Scaffold(
        topBar = {
            ShippingAddressTopBar(
                backToShippingMethodScreenClick = {
                    backToShippingMethodScreenClick()
                }
            )
        },
        bottomBar = {
            ShippingAddressBottomBar(
                onPaymentMethodClick = {
                    onPaymentMethodClick()
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(color = CustomGray.copy(alpha = 0.1f))
        ) {
            Spacer(modifier = Modifier.height(22.dp))
            Box(
                modifier = Modifier
                    .padding(horizontal = 59.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.address_wizard),
                    contentDescription = null,
                    modifier = Modifier
                        .width(297.dp)
                        .height(61.dp)
                )
            }
            Spacer(modifier = Modifier.height(42.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 17.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                ShippingAddressTextField(
                    leadingIcon = R.drawable.ic_name,
                    value = item.nameText,
                    label = "Name",
                    modifier = Modifier.size(24.dp),
                    onValueChange = {
                        shippingAddressViewModel.onEvent(
                            ShippingAddressEvent.OnNameTextChange(
                                name = it
                            )
                        )
                    }
                )
                ShippingAddressTextField(
                    leadingIcon = R.drawable.ic_email,
                    value = item.email,
                    label = "Email address",
                    modifier = Modifier
                        .width(23.dp)
                        .height(18.dp),
                    onValueChange = {
                        shippingAddressViewModel.onEvent(
                            ShippingAddressEvent.OnEmailTextChange(
                                value = it
                            )
                        )
                    }
                )
                ShippingAddressTextField(
                    leadingIcon = R.drawable.ic_telephone,
                    value = item.phoneNumber,
                    label = "Phone number",
                    modifier = Modifier.size(23.dp),
                    onValueChange = {
                        shippingAddressViewModel.onEvent(
                            ShippingAddressEvent.OnPhoneNumberTextChange(
                                number = it
                            )
                        )
                    }
                )
                ShippingAddressTextField(
                    leadingIcon = R.drawable.ic_address,
                    value = item.address,
                    label = "Address",
                    modifier = Modifier
                        .width(20.dp)
                        .height(26.dp),
                    onValueChange = {
                        shippingAddressViewModel.onEvent(
                            ShippingAddressEvent.OnAddressTextChange(
                                address = it
                            )
                        )
                    }
                )
                ShippingAddressTextField(
                    leadingIcon = R.drawable.ic_zip_code,
                    value = item.zipCode,
                    label = "Zip code",
                    modifier = Modifier
                        .width(26.dp)
                        .height(18.dp),
                    onValueChange = {
                        shippingAddressViewModel.onEvent(
                            ShippingAddressEvent.OnZipCodeTextChange(
                                value = it
                            )
                        )
                    }
                )
                ShippingAddressTextField(
                    leadingIcon = R.drawable.ic_city,
                    value = item.city,
                    label = "City",
                    modifier = Modifier.size(24.dp),
                    onValueChange = {
                        shippingAddressViewModel.onEvent(
                            ShippingAddressEvent.OnCityTextChange(
                                value = it
                            )
                        )
                    }
                )
                Box {
                    CountryTextField(
                        selectedCountry = item.country,
                        onExpandedClick = { expanded = !expanded }
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Country.entries.forEach { country ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = country.displayName(),
                                        style = TextStyle(
                                            fontFamily = AppFontFamily,
                                            fontSize = 14.sp
                                        )
                                    )
                                },
                                onClick = {
                                    shippingAddressViewModel.onEvent(
                                        ShippingAddressEvent.ChoseCountry(country)
                                    )
                                    expanded = false
                                }
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row() {
                    ShippingAddressSwitch(
                        onSave = {
                            shippingAddressViewModel.insertAddress(
                                item = ShippingAddress(
                                    name = item.nameText,
                                    email = item.email,
                                    phoneNumber = item.phoneNumber,
                                    address = item.address,
                                    zipCode = item.zipCode,
                                    city = item.city,
                                    country = item.country
                                )
                            )
                        }
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Save this address",
                        style = TextStyle(
                            fontFamily = AppFontFamily,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(500),
                            color = Color.Black,
                            letterSpacing = letterSpacing.sp
                        )
                    )
                }
            }
        }
    }
}


