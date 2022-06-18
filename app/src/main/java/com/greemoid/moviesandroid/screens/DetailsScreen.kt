package com.greemoid.moviesandroid.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.greemoid.moviesandroid.MainViewModel
import com.greemoid.moviesandroid.utils.HtmlText

@Composable
fun DetailsScreen(viewModel: MainViewModel, itemId: String) {
    val currentItem = viewModel.allMovies
        .observeAsState(listOf()).value
        .firstOrNull { it.id == itemId.toInt() }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 24.dp, horizontal = 8.dp)
    ) {
        LazyColumn {
            item {
                Column() {
                    Image(
                        painter = rememberImagePainter(currentItem?.image?.original),
                        contentDescription = "${currentItem?.name}",
                        modifier = Modifier.size(512.dp)
                    )
                    Text(
                         text = "${currentItem?.name}",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 16.dp)
                    )

                    Row(modifier = Modifier.padding(top = 8.dp)) {
                        Text(text = "Rating: ", fontWeight = FontWeight.Bold)
                        Text(text = currentItem?.rating?.average.toString())
                    }
                    Row(modifier = Modifier.padding(top = 8.dp)) {
                        Text(text = "Genre: ", fontWeight = FontWeight.Bold)
                        currentItem?.genres?.take(5)?.forEach{ Text(text = " $it ")}
                    }
                    Column(modifier = Modifier.padding(top = 8.dp)) {
                        Text(text = "Overview: ", fontWeight = FontWeight.Bold)
                        HtmlText(html = currentItem?.summary ?: "overview")
                    }
                    Row(modifier = Modifier.padding(top = 8.dp)) {
                        Text(text = "Premiered: ", fontWeight = FontWeight.Bold)
                        Text(text = currentItem?.premiered ?: "0000-00-00")
                    }
                }
            }
        }
    }
}