package com.example.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.theme.ProjetFilmsTheme

@Composable
fun ListMovies(toDetails: (Int) -> Unit, viewModel: ListViewModel?) {
    viewModel?.let {
        val state by viewModel.state.collectAsState()

        val effect = viewModel.effect
        LaunchedEffect(effect) {
            effect.collect { action ->
                when (action) {
                    is ListMoviesReducer.ListViewEffect.NavigateToDetails -> toDetails(action.movieId)
                }
            }
        }

        LazyColumn(
            modifier = Modifier
                .padding(vertical = 24.dp, horizontal = 17.dp),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            if (!state.popularMovies.isNullOrEmpty()) {
                item {
                    LineOfMovies(
                        movies = state.popularMovies.orEmpty(),
                        func = it::goToDetails,
                        title = stringResource(id = R.string.line_movies_title_popular),
                        lesgenres = state.genres.orEmpty()
                    )
                }
            }
            if (!state.upcomingMovies.isNullOrEmpty()) {
                item {
                    LineOfMovies(
                        movies = state.upcomingMovies.orEmpty(),
                        func = it::goToDetails,
                        title = stringResource(id = R.string.line_movies_title_upcoming),
                        lesgenres = state.genres.orEmpty()
                    )
                }
            }
            if (!state.topRatingMovies.isNullOrEmpty()) {
                item {
                    LineOfMovies(
                        movies = state.topRatingMovies.orEmpty(),
                        func = it::goToDetails,
                        title = stringResource(id = R.string.line_movies_title_topRated),
                        lesgenres = state.genres.orEmpty()
                    )
                }
            }
            if (!state.playingMovies.isNullOrEmpty()) {
                item {
                    LineOfMovies(
                        movies = state.playingMovies.orEmpty(),
                        func = it::goToDetails,
                        title = stringResource(id = R.string.line_movies_title_nowPlaying),
                        lesgenres = state.genres.orEmpty()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewList() {
    ProjetFilmsTheme {
        ListMovies(toDetails = {}, viewModel = null)
    }
}
