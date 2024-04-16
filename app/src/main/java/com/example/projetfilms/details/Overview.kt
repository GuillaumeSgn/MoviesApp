package com.example.projetfilms.details

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.projetfilms.network.MovieDetails
import com.example.projetfilms.ui.theme.ProjetFilmsTheme

@Composable
fun Overview(movie: MovieDetails?) {
    movie?.let {
        Text(text = "Overview", style = MaterialTheme.typography.headlineMedium)
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
        Overview(movie = null)
    }
}
