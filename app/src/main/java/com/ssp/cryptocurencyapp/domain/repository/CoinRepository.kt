package com.ssp.cryptocurencyapp.domain.repository

import com.ssp.cryptocurencyapp.data.remote.dto.CoinDto
import com.ssp.cryptocurencyapp.data.remote.dto.coinDetails.CoinsDetailDto

interface CoinRepository {

    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinById(coinId:String):CoinsDetailDto
}