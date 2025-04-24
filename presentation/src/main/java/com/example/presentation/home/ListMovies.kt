package com.example.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.listmovies.MovieListType
import com.example.domain.model.Genre
import com.example.domain.model.Movies
import com.example.presentation.theme.ProjetFilmsTheme

@Composable
fun ListMovies(toDetails: (Int) -> Unit, viewModel: ListViewModel) {
    viewModel.apply {
        val state by state.collectAsState()

        val effect = effect
        LaunchedEffect(effect) {
            effect.collect { action ->
                when (action) {
                    is ListMoviesReducer.ListViewEffect.NavigateToDetails -> toDetails(action.movieId)
                }
            }
        }
        ListMoviesContent(
            toDetails = viewModel::goToDetails,
            allMovies = state.allMovies,
            genres = state.genres.orEmpty()
        )
    }
}


@Composable
fun ListMoviesContent(
    toDetails: (Int) -> Unit,
    allMovies: Map<MovieListType, List<Movies>>,
    genres: List<Genre>
) {
    LazyColumn(
        modifier = Modifier
            .padding(vertical = 24.dp, horizontal = 17.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        items(items = allMovies.entries.toList()) { (title, movies) ->
            if (movies.isNotEmpty()) {
                LineOfMovies(
                    movies = movies,
                    func = toDetails,
                    title = title,
                    lesgenres = genres
                )
            }
        }

    }
}

@Preview
@Composable
private fun PreviewList() {
    ProjetFilmsTheme {
        ListMoviesContent(
            toDetails = {},
            allMovies = emptyMap(),
            genres = emptyList()
        )
    }
}
