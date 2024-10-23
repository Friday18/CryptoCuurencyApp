package com.ssp.cryptocurencyapp.domain.use_cases.get_coin

import com.ssp.cryptocurencyapp.common.Resource
import com.ssp.cryptocurencyapp.data.remote.dto.coinDetails.CoinDetail
import com.ssp.cryptocurencyapp.data.remote.dto.coinDetails.toCoinDetail
import com.ssp.cryptocurencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinByIdUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unauthorised error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach serve, please check your internet connection"))
        }
    }


}