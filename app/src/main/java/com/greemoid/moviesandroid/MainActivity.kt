package com.greemoid.moviesandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.greemoid.moviesandroid.navigation.SetupNavHost
import com.greemoid.moviesandroid.ui.theme.MoviesAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAndroidTheme {
                val navController = rememberNavController()
                SetupNavHost(navController = navController)
            }
        }
    }
}


