package com.example.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.carrouselLine.LineOfMovies
import com.example.presentation.theme.ProjetFilmsTheme

@Composable
fun ListMovies(toDetails: (Int) -> Unit, viewModel: ListViewModel?) {
    viewModel?.let {
        val moviesPop by viewModel.popular.collectAsState()
        val moviesUp by viewModel.upcoming.collectAsState()
        val moviesRate by viewModel.rating.collectAsState()
        val moviesPlay by viewModel.playing.collectAsState()
        val lesgenres by viewModel.genres.collectAsState()

        LazyColumn(
            modifier = Modifier
                .padding(vertical = 24.dp, horizontal = 17.dp),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            item {
                LineOfMovies(
                    movies = moviesPop,
                    func = toDetails,
                    title = stringResource(id = R.string.line_movies_title_popular),
                    lesgenres = lesgenres
                )
            }
            item {
                LineOfMovies(
                    movies = moviesUp,
                    func = toDetails,
                    title = stringResource(id = R.string.line_movies_title_upcoming),
                    lesgenres = lesgenres
                )
            }
            item {
                LineOfMovies(
                    movies = moviesRate,
                    func = toDetails,
                    title = stringResource(id = R.string.line_movies_title_topRated),
                    lesgenres = lesgenres
                )
            }
            item {
                LineOfMovies(
                    movies = moviesPlay,
                    func = toDetails,
                    title = stringResource(id = R.string.line_movies_title_nowPlaying),
                    lesgenres = lesgenres
                )
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
