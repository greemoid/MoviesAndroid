package com.greemoid.moviesandroid.screens

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.greemoid.moviesandroid.MainViewModel
import com.greemoid.moviesandroid.data.models.Movies

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    val allMovies = viewModel.allMovies.observeAsState(listOf()).value
    allMovies.forEach{
        Log.d("checkData", "ID: ${it.id}, name: ${it.name}")
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            items(allMovies.take(50)) { item ->
                MovieItem(item = item)
            }
        }
    }
}

@Composable
fun MovieItem(item: Movies) {
    Row(modifier = Modifier
        .fillMaxWidth().padding(16.dp)) {
        Text(text = item.id.toString(), modifier = Modifier.padding(end = 16.dp))
        Text(text = item.name)
    }
}