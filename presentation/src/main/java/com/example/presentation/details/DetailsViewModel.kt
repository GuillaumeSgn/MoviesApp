package com.example.presentation.details

import androidx.lifecycle.viewModelScope
import com.example.domain.details.GetActorsMovieUseCase
import com.example.domain.details.GetDetailsMovieUseCase
import com.example.domain.usecase.Result
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getDetailsMovieUseCase: GetDetailsMovieUseCase,
    private val getActorsMovieUseCase: GetActorsMovieUseCase,
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
            getDetailsMovieUseCase(movieId).collect { result ->
                when (result) {
                    is Result.Success -> sendEvent(
                        DetailsReducer.DetailsViewEvent.ShowMovie(
                            movie = result.data
                        )
                    )

                    is Result.BusinessRuleError -> Unit
                    is Result.Error -> Unit
                    Result.Loading -> Unit
                }
            }
        }
    }

    fun getActorsByMovieId(movieId: Int) {
        viewModelScope.launch {
            getActorsMovieUseCase(movieId).collect { result ->
                when (result) {
                    is Result.Success -> sendEvent(
                        DetailsReducer.DetailsViewEvent.ShowActors(
                            show = true,
                            actors = result.data.cast
                        )
                    )

                    is Result.BusinessRuleError -> Unit
                    is Result.Error -> Unit
                    Result.Loading -> Unit
                }
            }
        }
    }
}
