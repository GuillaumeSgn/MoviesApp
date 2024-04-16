package com.example.domain.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetfilms.network.Casting
import com.example.projetfilms.network.FilmApi
import com.example.projetfilms.network.MovieDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class DetailsViewModel : ViewModel() {

    private val _movieDetails = MutableStateFlow<MovieDetails?>(null)
    val movieDetails: StateFlow<MovieDetails?> = _movieDetails.asStateFlow()

    private val _movieCredits = MutableStateFlow<List<Casting?>>(emptyList())
    val movieCredits: StateFlow<List<Casting?>> = _movieCredits.asStateFlow()

    fun getMovieById(movieId: Int) {
        viewModelScope.launch {
            try {
                val theMovie = FilmApi.retrofitService.findMovieById(movieId = movieId)
                _movieDetails.value = theMovie
            } catch (e: IOException) {
                Log.e("MovieId", e.stackTraceToString())
                _movieDetails.value = null
            }
        }
    }

    fun getActorsByMovieId(movieId: Int) {
        viewModelScope.launch {
            try {
                val actors = FilmApi.retrofitService.getActorsOfMovie(movieId = movieId)
                _movieCredits.value = actors.cast
            } catch (e: IOException) {
                Log.e("MovieId", e.stackTraceToString())
                _movieCredits.value = emptyList()
            }
        }
    }
}
