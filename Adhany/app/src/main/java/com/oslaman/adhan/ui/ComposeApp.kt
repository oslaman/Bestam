package com.oslaman.adhan.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oslaman.adhan.ui.prayer.PrayerScreen

@Composable
fun ComposeApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.PRAYERS
    ) {
        composable(Route.PRAYERS) {
            PrayerScreen()
        }
        /*composable(Route.SETTINGS) {
            SettingsScreen()
        }*/
    }
}

object Route {
    const val PRAYERS = "prayers"
    const val SETTINGS = "settings"
}