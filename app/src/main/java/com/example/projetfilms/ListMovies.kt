package com.example.projetfilms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetfilms.carrouselLine.LineOfMovies
import com.example.projetfilms.fakedata.Movies
import com.example.projetfilms.fakedata.getAllMovies
import com.example.projetfilms.ui.theme.ProjetFilmsTheme

@Composable
fun ListMovies(movies: List<Movies> = getAllMovies(), toDetails: (Int) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .padding(vertical = 24.dp, horizontal = 17.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        item {
            LineOfMovies(movies = movies, func = toDetails, title = "Type de film")
        }
        item {
            LineOfMovies(movies = movies,  func = toDetails, title = "Type de film")
        }
        item {
            LineOfMovies(movies = movies,  func = toDetails, title = "Type de film")
        }
    }
}

@Preview
@Composable
private fun PreviewList() {
    ProjetFilmsTheme {
        ListMovies(movies = getAllMovies(), toDetails = {})
    }
}
