package com.ssp.cryptocurencyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ssp.cryptocurencyapp.presentation.coin_details.CoinsDetailScreen
import com.ssp.cryptocurencyapp.presentation.coin_list.CoinListScreen
import com.ssp.cryptocurencyapp.presentation.theme.CryptocurencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurencyAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.CoinListScreen.route
                    ) {
                        composable(
                            route = Screens.CoinListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }
                        composable(route = Screens.CoinDetailScreen.route + "/{coinId}") {
                            CoinsDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
