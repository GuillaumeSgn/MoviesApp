package com.example.presentation.details

import androidx.lifecycle.viewModelScope
import com.example.domain.repository.MovieRepository
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: MovieRepository
) : BaseViewModel<DetailsReducer.DetailsViewState, DetailsReducer.DetailsViewEvent, DetailsReducer.DetailsViewEffect>(
    initialState = DetailsReducer.DetailsViewState.initial(),
    reducer = DetailsReducer()
) {

    init {
        viewModelScope.launch {
            sendEvent(
                DetailsReducer.DetailsViewEvent.ShowPoster(
                    show = true
                )
            )
            sendEvent(
                DetailsReducer.DetailsViewEvent.ShowButtons(
                    show = true
                )
            )
            sendEvent(
                DetailsReducer.DetailsViewEvent.ShowInfos(
                    infosMovie = true
                )
            )
            sendEvent(
                DetailsReducer.DetailsViewEvent.ShowOverview(
                    overview = true
                )
            )
        }
    }

    fun getMovieById(movieId: Int) {
        viewModelScope.launch {
            sendEvent(
                DetailsReducer.DetailsViewEvent.ShowMovie(
                    movie = repository.findMovieById(movieId = movieId)
                )
            )
        }
    }

    fun getActorsByMovieId(movieId: Int) {
        viewModelScope.launch {
            sendEvent(
                DetailsReducer.DetailsViewEvent.ShowActors(
                    show = true,
                    actors = repository.getActorsOfMovie(movieId = movieId).cast
                )
            )
        }
    }
}
