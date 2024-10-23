package com.ssp.cryptocurencyapp.presentation.coin_list

import com.ssp.cryptocurencyapp.data.remote.dto.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
