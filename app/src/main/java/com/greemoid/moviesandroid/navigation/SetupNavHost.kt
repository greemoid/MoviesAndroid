package com.greemoid.moviesandroid.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.greemoid.moviesandroid.screens.DetailsScreen
import com.greemoid.moviesandroid.screens.MainScreen
import com.greemoid.moviesandroid.screens.SplashScreen
import com.greemoid.moviesandroid.utils.Constants.Screens.DETAILS_SCREEN
import com.greemoid.moviesandroid.utils.Constants.Screens.MAIN_SCREEN
import com.greemoid.moviesandroid.utils.Constants.Screens.SPLASH_SCREEN

sealed class Screens(val route: String) {
    object Splash : Screens(route = SPLASH_SCREEN)
    object Main : Screens(route = MAIN_SCREEN)
    object Details : Screens(route = DETAILS_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavHostController) {
    NavHost(navController = navController,
        startDestination = Screens.Splash.route) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController)
        }
        composable(route = Screens.Main.route) {
            MainScreen()
        }
        composable(route = Screens.Details.route) {
            DetailsScreen()
        }
    }
}