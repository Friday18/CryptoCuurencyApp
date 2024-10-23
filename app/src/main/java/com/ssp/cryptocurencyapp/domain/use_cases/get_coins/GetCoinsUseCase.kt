package com.ssp.cryptocurencyapp.domain.use_cases.get_coins

import com.ssp.cryptocurencyapp.common.Resource
import com.ssp.cryptocurencyapp.data.remote.dto.Coin
import com.ssp.cryptocurencyapp.data.remote.dto.toCoin
import com.ssp.cryptocurencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map {
                it.toCoin()
            }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured "))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach serve, please check your internet connection"))
        }
    }
}