package com.example.presentation.details

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.domain.Genre
import com.example.domain.MovieDetails
import com.example.presentation.R
import com.example.presentation.theme.ProjetFilmsTheme

@Composable
fun Overview(movie: MovieDetails?) {
    movie?.let {
        Text(
            text = stringResource(id = R.string.overview_title),
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = it.overview,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}

@Preview
@Composable
fun PreviewOverview() {
    ProjetFilmsTheme {
        Overview(
            movie = MovieDetails(
                title = "truc",
                poster = "truc",
                overview = "truc",
                date = "truc",
                genres = listOf(
                    Genre(id = 0, name = "truc")
                )
            )
        )
    }
}
