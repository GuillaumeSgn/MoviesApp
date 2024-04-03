package com.example.projetfilms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.projetfilms.fakedata.Movies
import com.example.projetfilms.fakedata.getAllMovies

@Composable
fun ListMovies(movies: List<Movies> = getAllMovies()) {
    LazyColumn(
        modifier = Modifier
            .padding(vertical = 24.dp, horizontal = 17.dp)
            .background(color = Color.Blue),
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        items(items = movies) { item ->
            LineOfCarrousel(movies = movies)
        }
    }
}


@Composable
fun LineOfCarrousel(movies: List<Movies>) {
    LazyRow(modifier = Modifier
        .background(color = Color.Red),
        horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items = movies) { item ->
            MovieCard(
                title = item.title,
                synopsis = item.synopsis,
                rating = item.rating.toString()
            )
        }

    }

}


@Composable
fun MovieCard(title: String, synopsis: String, rating: String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(text = "Type de films")
        Column {
            Text(text = title)
            Text(text = synopsis)
            Text(text = rating)
        }
    }

}