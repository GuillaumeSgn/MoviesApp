package com.example.presentation.carrouselLine

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.Genre
import com.example.domain.Movies
import com.example.presentation.carrouselCard.MovieCard
import com.example.presentation.theme.ProjetFilmsTheme

@Composable
fun LineOfMovies(
    movies: List<Movies>,
    func: (Int) -> Unit,
    title: String,
    lesgenres: List<Genre>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(text = title, style = MaterialTheme.typography.titleLarge)
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
        LineOfMovies(movies = emptyList(), func = {}, title = "titre", emptyList())
    }
}
