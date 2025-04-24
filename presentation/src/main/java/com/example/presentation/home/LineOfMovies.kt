package com.example.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.listmovies.MovieListType
import com.example.domain.model.Genre
import com.example.domain.model.Movies
import com.example.presentation.R
import com.example.presentation.carrouselCard.MovieCard
import com.example.presentation.theme.ProjetFilmsTheme

@Composable
fun LineOfMovies(
    movies: List<Movies>,
    func: (Int) -> Unit,
    title: MovieListType,
    lesgenres: List<Genre>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = stringResource(
                id = when (title) {
                    MovieListType.UPCOMING -> R.string.line_movies_title_upcoming
                    MovieListType.POPULAR -> R.string.line_movies_title_popular
                    MovieListType.TOP_RATED -> R.string.line_movies_title_topRated
                    MovieListType.NOW_PLAYING -> R.string.line_movies_title_nowPlaying
                }
            ), style = MaterialTheme.typography.titleLarge
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = movies) {
                MovieCard(movie = it, toDetails = func, lesgenres = lesgenres)
            }
        }
    }
}

@Preview
@Composable
fun PreviewLineOfMovies() {
    ProjetFilmsTheme {
        LineOfMovies(movies = emptyList(), func = {}, title = MovieListType.TOP_RATED, emptyList())
    }
}
