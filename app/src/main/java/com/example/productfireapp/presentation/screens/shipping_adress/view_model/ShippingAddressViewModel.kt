package com.example.productfireapp.presentation.screens.shipping_adress.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productfireapp.domain.models.ShippingAddress
import com.example.productfireapp.domain.repositories.ShippingAddressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ShippingAddressViewModel @Inject constructor(
    private val repository: ShippingAddressRepository
) : ViewModel() {
    private val _shippingAddressUiEvent = Channel<ShippingAddressUiEvent>(Channel.BUFFERED)
    val shippingAddressUiEvent = _shippingAddressUiEvent.receiveAsFlow()
    private val _shippingAddressUiState = MutableStateFlow(
        ShippingAddressUiState()
    )
    val shippingAddressUiState = _shippingAddressUiState.asStateFlow()

    fun insertAddress(item: ShippingAddress) {
        viewModelScope.launch {
            repository.insertAddress(item)
        }
    }

    fun deleteAddress(item: ShippingAddress) {
        viewModelScope.launch {
            repository.deleteAddress(item)
        }
    }

    fun onEvent(event: ShippingAddressEvent) {
        when (event) {
            is ShippingAddressEvent.OnNameTextChange -> {
                _shippingAddressUiState.update { state ->
                    state.copy(
                        nameText = event.name
                    )
                }
            }

            is ShippingAddressEvent.OnEmailTextChange -> {
                _shippingAddressUiState.update { state ->
                    state.copy(
                        email = event.value
                    )
                }
            }

            is ShippingAddressEvent.OnPhoneNumberTextChange -> {
                _shippingAddressUiState.update { state ->
                    state.copy(
                        phoneNumber = event.number
                    )
                }
            }

            is ShippingAddressEvent.OnAddressTextChange -> {
                _shippingAddressUiState.update { state ->
                    state.copy(
                        address = event.address
                    )
                }
            }

            is ShippingAddressEvent.OnZipCodeTextChange -> {
                _shippingAddressUiState.update { state ->
                    state.copy(
                        zipCode = event.value
                    )
                }
            }

            is ShippingAddressEvent.OnCityTextChange -> {
                _shippingAddressUiState.update { state ->
                    state.copy(
                        city = event.value
                    )
                }
            }
            is ShippingAddressEvent.ChoseCountry -> {
                _shippingAddressUiState.update { state ->
                    state.copy(
                        country = event.country
                    )
                }
            }
        }
    }
}





