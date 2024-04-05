package com.example.projetfilms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetfilms.fakedata.Movies
import com.example.projetfilms.fakedata.getAllMovies
import com.example.projetfilms.ui.theme.ProjetFilmsTheme

@Composable
fun ListMovies(movies: List<Movies> = getAllMovies()) {
    LazyColumn(
        modifier = Modifier
            .padding(vertical = 24.dp, horizontal = 17.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        items(items = movies) { item ->
            LineOfCarrousel(movies = listOf(item, item, item))
        }
    }
}

@Preview
@Composable
private fun PreviewList() {
    ProjetFilmsTheme {
        ListMovies()
    }
}
