package com.ssp.cryptocurencyapp.data.remote

import com.ssp.cryptocurencyapp.data.remote.dto.CoinDto
import com.ssp.cryptocurencyapp.data.remote.dto.coinDetails.CoinsDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPI {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinsDetailDto
}