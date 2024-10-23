package com.ssp.cryptocurencyapp.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssp.cryptocurencyapp.common.Constants
import com.ssp.cryptocurencyapp.common.Resource
import com.ssp.cryptocurencyapp.domain.use_cases.get_coin.GetCoinByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(GetCoinByIdState())
    val state: State<GetCoinByIdState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {
            getCoinById(it)
        }
    }

    private fun getCoinById(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value =
                        GetCoinByIdState(data = result.data)
                }

                is Resource.Error -> {
                    _state.value =
                        GetCoinByIdState(error = result.message ?: "Unexpected Error Occurred")
                }

                is Resource.Loading -> {
                    _state.value = GetCoinByIdState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}