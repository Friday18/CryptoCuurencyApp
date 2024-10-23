package com.ssp.cryptocurencyapp.presentation.coin_details

import com.ssp.cryptocurencyapp.data.remote.dto.coinDetails.CoinDetail

data class GetCoinByIdState(
    val isLoading: Boolean = false,
    val data: CoinDetail? = null,
    val error: String = ""

)