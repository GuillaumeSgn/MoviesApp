package com.example.presentation.details

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.projetfilms.network.Genre
import com.example.projetfilms.network.MovieDetails
import com.example.projetfilms.ui.theme.ProjetFilmsTheme

@Composable
fun InfosMovie(movie: MovieDetails?, genres: String) {
    movie?.let {
        Text(
            text = it.title,
            style = MaterialTheme.typography.titleMedium,
        )
        Text(
            text = it.date + " . " + genres + " . ",
            style = MaterialTheme.typography.labelLarge,
        )
    }
}

@Preview
@Composable
fun PreviewInfosMovie() {
    ProjetFilmsTheme {
        InfosMovie(
            movie = MovieDetails(
                title = "truc",
                poster = "truc",
                overview = "truc",
                date = "truc",
                genres = listOf(
                    Genre(id = 0, name = "truc")
                )
            ),
            "gneuh"
        )
    }
}
