package com.example.presentation.home

import com.example.domain.listmovies.MovieListType
import com.example.domain.model.Genre
import com.example.domain.model.Movies
import com.example.presentation.base.Reducer
import javax.annotation.concurrent.Immutable

class ListMoviesReducer :
    Reducer<ListMoviesReducer.ListViewState, ListMoviesReducer.ListViewEvent, ListMoviesReducer.ListViewEffect> {

    @Immutable
    sealed class ListViewEvent : Reducer.ViewEvent {
        data class OnMovieClick(val movieId: Int) : ListViewEvent()
        data class ShowGenre(val genre: List<Genre>) : ListViewEvent()

        data class ShowAllMovies(val movies: Map<MovieListType, List<Movies>>) : ListViewEvent()
    }

    @Immutable
    data class ListViewState(
        val allMovies: Map<MovieListType,List<Movies>>,
        val genres: List<Genre>?
    ) : Reducer.ViewState {
        companion object {
            fun initial() = ListViewState(
                allMovies= emptyMap(),
                genres = null
            )
        }
    }

    @Immutable
    sealed class ListViewEffect : Reducer.ViewEffect {
        data class NavigateToDetails(val movieId: Int) : ListViewEffect()
    }

    override fun reduce(
        previousState: ListViewState,
        event: ListViewEvent
    ): Pair<ListViewState, ListViewEffect?> {
        return when (event) {
            is ListViewEvent.OnMovieClick -> previousState to ListViewEffect.NavigateToDetails(event.movieId)

            is ListViewEvent.ShowGenre -> previousState.copy(
                genres = event.genre
            ) to null

            is ListViewEvent.ShowAllMovies -> previousState.copy(
                allMovies = event.movies
            ) to null
        }
    }
}
