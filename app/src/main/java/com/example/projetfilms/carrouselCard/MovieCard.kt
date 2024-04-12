package com.example.projetfilms.carrouselCard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.projetfilms.fakedata.Movies
import com.example.projetfilms.ui.theme.ProjetFilmsTheme
import com.example.projetfilms.viewModel.ListViewModel

@Composable
fun MovieCard(
    movie: Movies,
    modifier: Modifier = Modifier,
    toDetails: (Int) -> Unit,
    viewModel: ListViewModel?
) {
    viewModel?.let {
        val lesgenres by viewModel.genres.collectAsState()

        val filterString = lesgenres.filter { (int,_) -> int in movie.genre }.map { it.name }
        val resultString = filterString.joinToString(separator = ",")

        val painter =
            rememberAsyncImagePainter(model = "https://image.tmdb.org/t/p/w1280${movie.poster}")
        CustomCard(
            image = painter,
            title = movie.title,
            subtitle = resultString,
            modifier = modifier
                .clickable { toDetails(movie.movieId) }
                .width(150.dp),
            isMovie = true,

        )
    }
}

@Preview
@Composable
private fun PreviewCard() {
    ProjetFilmsTheme {
        MovieCard(
            Movies(
                0,
                "title of the first movie",
                "synopsis ...",
                87f,
                listOf(1),
                "poster",
                "date"
            ),
            toDetails = {},
            viewModel = null
        )

    }
}