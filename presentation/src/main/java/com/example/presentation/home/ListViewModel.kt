package com.example.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Genre
import com.example.domain.Movies
import java.io.IOException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private val _popular = MutableStateFlow<List<Movies>>(emptyList())
    val popular: StateFlow<List<Movies>> = _popular.asStateFlow()

    private val _playing = MutableStateFlow<List<Movies>>(emptyList())
    val playing: StateFlow<List<Movies>> = _playing.asStateFlow()

    private val _rating = MutableStateFlow<List<Movies>>(emptyList())
    val rating: StateFlow<List<Movies>> = _rating.asStateFlow()

    private val _upcoming = MutableStateFlow<List<Movies>>(emptyList())
    val upcoming: StateFlow<List<Movies>> = _upcoming.asStateFlow()

    private val _genres = MutableStateFlow<List<Genre>>(emptyList())
    val genres: StateFlow<List<Genre>> = _genres.asStateFlow()

    init {
        getListMoviePopular()
        getListMoviePlaying()
        getListMovieRating()
        getListMovieUpcoming()
        getAllGenres()
    }

    private fun getListMoviePopular() {
        viewModelScope.launch {
            try {
//                val listM = FilmApi.retrofitService.getListPopular()
//                _popular.value = listM.results
            } catch (e: IOException) {
                Log.e("viewmodel", e.stackTraceToString())

                _popular.value = emptyList()
            }
        }
    }

    private fun getListMoviePlaying() {
        viewModelScope.launch {
            try {
//                val listM = FilmApi.retrofitService.getListNowPlaying()
//                _playing.value = listM.results
            } catch (e: IOException) {
                Log.e("viewmodel", e.stackTraceToString())

                _playing.value = emptyList()
            }
        }
    }

    private fun getListMovieRating() {
        viewModelScope.launch {
            try {
//                val listM = FilmApi.retrofitService.getListTopRated()
//                _rating.value = listM.results
            } catch (e: IOException) {
                Log.e("viewmodel", e.stackTraceToString())
                _rating.value = emptyList()
            }
        }
    }

    private fun getListMovieUpcoming() {
        viewModelScope.launch {
            try {
//                val listM = FilmApi.retrofitService.getListUpcoming()
//                _upcoming.value = listM.results
            } catch (e: IOException) {
                Log.e("viewmodelMovies", e.stackTraceToString())
                _upcoming.value = emptyList()
            }
        }
    }

    private fun getAllGenres() {
        viewModelScope.launch {
            try {
//                val listGenre = FilmApi.retrofitService.getAllGenres()
//                _genres.value = listGenre.genres
//                Log.v("viewmodelGenres", listGenre.toString())
            } catch (e: IOException) {
                Log.e("viewmodelGenres", e.stackTraceToString())
                _genres.value = emptyList()
            }
        }
    }
}
