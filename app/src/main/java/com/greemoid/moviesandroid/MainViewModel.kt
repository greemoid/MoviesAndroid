package com.greemoid.moviesandroid

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.moviesandroid.data.models.Movies
import com.greemoid.moviesandroid.data.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val apiRepository: ApiRepository): ViewModel() {

    private val _allMovies = MutableLiveData<List<Movies>>()
    val allMovies: LiveData<List<Movies>>
        get() = _allMovies

    fun getAllMovies() {
        viewModelScope.launch {
            apiRepository.getAllMovies().let {
                if (it.isSuccessful) {
                    _allMovies.postValue(it.body())
                } else {
                    Log.d("checkData", "Failed to download movies: ${it.errorBody()}")
                }
            }
        }
    }
}