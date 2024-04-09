package com.example.projetfilms.details

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.projetfilms.fakedata.Movies
import com.example.projetfilms.fakedata.getMovieById
import com.example.projetfilms.ui.theme.ProjetFilmsTheme

@Composable
fun InfosMovie(movie: Movies) {
    Text(
        text = movie.title,
        style = MaterialTheme.typography.titleMedium,
    )
    Text(
        text = movie.date + " . " + movie.genre + " . " + movie.duree,
        style = MaterialTheme.typography.labelLarge,
    )
}

@Preview
@Composable
fun PreviewInfosMovie() {
    ProjetFilmsTheme {
        getMovieById(0)?.let { InfosMovie(movie = it) }
    }
}