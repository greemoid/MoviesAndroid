package com.greemoid.moviesandroid.data.network

import com.greemoid.moviesandroid.data.models.Movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("shows")
    suspend fun getAllMovies(): Response<List<Movies>>
}