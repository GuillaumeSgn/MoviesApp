package com.example.presentation.home

import androidx.lifecycle.viewModelScope
import com.example.domain.listmovies.GetListMoviesUseCase
import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.Result
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: MovieRepository,
    private val getListMoviesUseCase: GetListMoviesUseCase
) : BaseViewModel<ListMoviesReducer.ListViewState, ListMoviesReducer.ListViewEvent, ListMoviesReducer.ListViewEffect>(
    initialState = ListMoviesReducer.ListViewState.initial(),
    reducer = ListMoviesReducer()
) {
    init {
        viewModelScope.launch {
            getListMoviesUseCase(Unit).collect { result ->
                when (result) {
                    is Result.BusinessRuleError -> Unit
                    is Result.Error -> Unit
                    Result.Loading -> Unit
                    is Result.Success -> sendEvent(
                        ListMoviesReducer.ListViewEvent.ShowAllMovies(
                            movies = result.data
                        )
                    )
                }
            }
            sendEvent(ListMoviesReducer.ListViewEvent.ShowGenre(genre = repository.getAllGenres().genres))
        }
    }

    fun goToDetails(movieId: Int) {
        viewModelScope.launch {
            sendEventForEffect(ListMoviesReducer.ListViewEvent.OnMovieClick(movieId))
        }
    }
}
