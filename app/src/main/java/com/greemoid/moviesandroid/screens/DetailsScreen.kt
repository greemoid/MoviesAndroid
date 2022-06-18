package com.greemoid.moviesandroid.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.greemoid.moviesandroid.MainViewModel

@Composable
fun DetailsScreen(navController: NavController, viewModel: MainViewModel, itemId: String) {
    
    Text(text = " item id: $itemId")
}