package com.example.projetfilms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetfilms.fakedata.Movies
import com.example.projetfilms.fakedata.getAllMovies
import com.example.projetfilms.ui.theme.ProjetFilmsTheme

@Composable
fun LineOfCarrousel(movies: List<Movies>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(text = "type de film", style = MaterialTheme.typography.titleMedium)
        LazyRow(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = movies) { item ->
                MovieCard(
                    item
                )
            }

        }

    }
}

@Preview
@Composable
private fun PreviewLine() {
    ProjetFilmsTheme {
        LineOfCarrousel(movies = getAllMovies())

    }
}