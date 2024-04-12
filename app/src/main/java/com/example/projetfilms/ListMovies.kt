package com.example.projetfilms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetfilms.carrouselLine.LineOfMovies
import com.example.projetfilms.ui.theme.ProjetFilmsTheme
import com.example.projetfilms.viewModel.ListViewModel


@Composable
fun ListMovies(toDetails: (Int) -> Unit, viewModel: ListViewModel?) {

    viewModel?.let {
        val moviesPop by viewModel.popular.collectAsState()
        val moviesUp by viewModel.upcoming.collectAsState()
        val moviesRate by viewModel.rating.collectAsState()
        val moviesPlay by viewModel.playing.collectAsState()

        LazyColumn(
            modifier = Modifier
                .padding(vertical = 24.dp, horizontal = 17.dp),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            item {
                LineOfMovies(movies = moviesPop, func = toDetails, title = "Popular",viewModel = viewModel)
            }
            item {
                LineOfMovies(movies = moviesUp, func = toDetails, title = "Upcoming",viewModel = viewModel)
            }
            item {
                LineOfMovies(movies = moviesRate, func = toDetails, title = "Top Rated",viewModel = viewModel)
            }
            item {
                LineOfMovies(movies = moviesPlay, func = toDetails, title = "Now Playing",viewModel = viewModel)
            }
        }
    }

}

@Preview
@Composable
private fun PreviewList() {
    ProjetFilmsTheme {
        ListMovies(toDetails = {}, viewModel = null)
    }
}
