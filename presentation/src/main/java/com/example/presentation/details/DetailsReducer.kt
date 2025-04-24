package com.example.presentation.details

import com.example.domain.model.Casting
import com.example.domain.model.MovieDetails
import com.example.presentation.base.Reducer
import javax.annotation.concurrent.Immutable

class DetailsReducer :
    Reducer<DetailsReducer.DetailsViewState, DetailsReducer.DetailsViewEvent, DetailsReducer.DetailsViewEffect> {

    @Immutable
    sealed class DetailsViewEvent : Reducer.ViewEvent {
        data object OnBackClick : DetailsViewEvent()
        data class ShowPoster(val show: Boolean) : DetailsViewEvent()
        data class ShowInfos(val infosMovie: Boolean) : DetailsViewEvent()
        data class ShowButtons(val show: Boolean) : DetailsViewEvent()
        data class ShowOverview(val overview: Boolean) : DetailsViewEvent()
        data class ShowActors(val show: Boolean, val actors: List<Casting>) : DetailsViewEvent()
        data class ShowMovie(val movie: MovieDetails?) : DetailsViewEvent()
    }

    @Immutable
    data class DetailsViewState(
        val backBouton: Boolean,
        val poster: Boolean,
        val infosMovie: Boolean,
        val buttons: Boolean,
        val overview: Boolean,
        val actors: List<Casting>,
        val showActors: Boolean,
        val movie: MovieDetails?
    ) : Reducer.ViewState {
        companion object {
            fun initial() = DetailsViewState(
                backBouton = true,
                poster = false,
                infosMovie = false,
                buttons = false,
                overview = false,
                actors = emptyList(),
                showActors = false,
                movie = null
            )
        }
    }

    @Immutable
    sealed class DetailsViewEffect : Reducer.ViewEffect {
        data object BackToList : DetailsViewEffect()
    }

    override fun reduce(
        previousState: DetailsViewState,
        event: DetailsViewEvent
    ): Pair<DetailsViewState, DetailsViewEffect?> {
        return when (event) {
            DetailsViewEvent.OnBackClick -> previousState to DetailsViewEffect.BackToList
            is DetailsViewEvent.ShowActors -> previousState.copy(
                showActors = event.show,
                actors = event.actors
            ) to null

            is DetailsViewEvent.ShowButtons -> previousState.copy(
                buttons = event.show
            ) to null

            is DetailsViewEvent.ShowInfos -> previousState.copy(
                infosMovie = event.infosMovie
            ) to null

            is DetailsViewEvent.ShowOverview -> previousState.copy(
                overview = event.overview
            ) to null

            is DetailsViewEvent.ShowPoster -> previousState.copy(
                poster = event.show
            ) to null

            is DetailsViewEvent.ShowMovie -> previousState.copy(
                movie = event.movie
            ) to null
        }
    }
}
