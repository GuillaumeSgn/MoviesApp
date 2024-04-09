package com.example.projetfilms.details

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.projetfilms.fakedata.Movies
import com.example.projetfilms.fakedata.getMovieById
import com.example.projetfilms.ui.theme.ProjetFilmsTheme

@Composable
fun Overview(movie: Movies) {
    Text(text = "Overview", style = MaterialTheme.typography.headlineMedium)
    Text(
        text = movie.synopsis,
        style = MaterialTheme.typography.bodySmall,
    )

}

@Preview
@Composable
fun PreviewOverview() {
    ProjetFilmsTheme {
        getMovieById(0)?.let { Overview(movie = it) }
    }
}