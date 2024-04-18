package com.example.presentation.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Casting
import com.example.domain.MovieDetails
import com.example.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _movieDetails = MutableStateFlow<MovieDetails?>(null)
    val movieDetails: StateFlow<MovieDetails?> = _movieDetails.asStateFlow()

    private val _movieCredits = MutableStateFlow<List<Casting?>>(emptyList())
    val movieCredits: StateFlow<List<Casting?>> = _movieCredits.asStateFlow()

    fun getMovieById(movieId: Int) {
        viewModelScope.launch {
            try {
                val theMovie = repository.findMovieById(movieId = movieId)
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
                val actors = repository.getActorsOfMovie(movieId = movieId)
                _movieCredits.value = actors.cast
            } catch (e: IOException) {
                Log.e("MovieId", e.stackTraceToString())
                _movieCredits.value = emptyList()
            }
        }
    }
}
