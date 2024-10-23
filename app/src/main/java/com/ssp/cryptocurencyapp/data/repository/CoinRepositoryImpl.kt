package com.ssp.cryptocurencyapp.data.repository

import com.ssp.cryptocurencyapp.data.remote.CoinPaprikaAPI
import com.ssp.cryptocurencyapp.data.remote.dto.CoinDto
import com.ssp.cryptocurencyapp.data.remote.dto.coinDetails.CoinsDetailDto
import com.ssp.cryptocurencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaAPI
):CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinsDetailDto {
        return api.getCoinById(coinId)
    }
}