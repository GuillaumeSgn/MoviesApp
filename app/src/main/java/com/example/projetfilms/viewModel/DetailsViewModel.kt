package com.example.projetfilms.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetfilms.network.FilmApi
import com.example.projetfilms.network.MovieDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {

    private val _movieDetails = MutableStateFlow<MovieDetails?>(null)
    val movieDetails: StateFlow<MovieDetails?> = _movieDetails.asStateFlow()

    fun getMovieById(movieId: Int) {
        viewModelScope.launch {
            try {
                val theMovie = FilmApi.retrofitService.findMovieById(movieId = movieId)
                _movieDetails.value = theMovie
            } catch (e: Exception) {
                Log.e("MovieId", e.stackTraceToString())
                _movieDetails.value = null
            }
        }

    }
}