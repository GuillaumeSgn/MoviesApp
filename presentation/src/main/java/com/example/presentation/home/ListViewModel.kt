package com.example.presentation.home

import androidx.lifecycle.viewModelScope
import com.example.domain.repository.MovieRepository
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: MovieRepository,
) : BaseViewModel<ListMoviesReducer.ListViewState, ListMoviesReducer.ListViewEvent, ListMoviesReducer.ListViewEffect>(
    initialState = ListMoviesReducer.ListViewState.initial(),
    reducer = ListMoviesReducer()
) {
    init {
        viewModelScope.launch {
            sendEvent(
                ListMoviesReducer.ListViewEvent.ShowListPop(
                    title = true,
                    popList = repository.getListPopular().results
                )
            )
            sendEvent(
                ListMoviesReducer.ListViewEvent.ShowListUp(
                    title = true,
                    upcoming = repository.getListUpcoming().results
                )
            )
            sendEvent(
                ListMoviesReducer.ListViewEvent.ShowListPlaying(
                    title = true,
                    playing = repository.getListNowPlaying().results
                )
            )
            sendEvent(
                ListMoviesReducer.ListViewEvent.ShowListRating(
                    title = true,
                    rating = repository.getListTopRated().results
                )
            )
            sendEvent(ListMoviesReducer.ListViewEvent.ShowGenre(genre = repository.getAllGenres().genres))
        }
    }

    fun goToDetails(movieId: Int) {
        viewModelScope.launch {
            sendEventForEffect(ListMoviesReducer.ListViewEvent.OnMovieClick(movieId))
        }
    }
}
