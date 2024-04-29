package com.example.presentation.home

import com.example.domain.Genre
import com.example.domain.Movies
import com.example.presentation.base.Reducer
import javax.annotation.concurrent.Immutable

class ListMoviesReducer :
    Reducer<ListMoviesReducer.ListViewState, ListMoviesReducer.ListViewEvent, ListMoviesReducer.ListViewEffect> {

    @Immutable
    sealed class ListViewEvent : Reducer.ViewEvent {
        data class OnMovieClick(val movieId: Int) : ListViewEvent()
        data class ShowListPop(val title: Boolean, val popList: List<Movies>) : ListViewEvent()
        data class ShowListUp(val title: Boolean, val upcoming: List<Movies>) : ListViewEvent()
        data class ShowListPlaying(val title: Boolean, val playing: List<Movies>) : ListViewEvent()
        data class ShowListRating(val title: Boolean, val rating: List<Movies>) : ListViewEvent()
        data class ShowGenre(val genre: List<Genre>) : ListViewEvent()
    }

    @Immutable
    data class ListViewState(
        val titlePop: Boolean,
        val titleUp: Boolean,
        val titleRating: Boolean,
        val titlePlaying: Boolean,
        val popularMovies: List<Movies>?,
        val playingMovies: List<Movies>?,
        val topRatingMovies: List<Movies>?,
        val upcomingMovies: List<Movies>?,
        val genres: List<Genre>?
    ) : Reducer.ViewState {
        companion object {
            fun initial() = ListViewState(
                titlePop = false,
                titleUp = false,
                titleRating = false,
                titlePlaying = false,
                popularMovies = null,
                playingMovies = null,
                topRatingMovies = null,
                upcomingMovies = null,
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

            is ListViewEvent.ShowListPop -> previousState.copy(
                titlePop = event.title,
                popularMovies = event.popList
            ) to null

            is ListViewEvent.ShowListPlaying -> previousState.copy(
                titlePlaying = event.title,
                playingMovies = event.playing
            ) to null

            is ListViewEvent.ShowListRating -> previousState.copy(
                titleRating = event.title,
                topRatingMovies = event.rating
            ) to null

            is ListViewEvent.ShowListUp -> previousState.copy(
                titleUp = event.title,
                upcomingMovies = event.upcoming
            ) to null

            is ListViewEvent.ShowGenre -> previousState.copy(
                genres = event.genre
            ) to null
        }
    }
}
