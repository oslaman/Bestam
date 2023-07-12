package com.oslaman.bestam.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oslaman.bestam.ui.exchange.ExchangeScreen

@Composable
fun ExchangeApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.HOME
    ) {
        composable(Route.HOME) {
            ExchangeScreen()
        }
    }
}

object Route {
    const val HOME = "home"
}