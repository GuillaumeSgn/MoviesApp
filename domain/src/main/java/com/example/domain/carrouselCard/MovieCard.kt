package com.example.domain.carrouselCard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.projetfilms.fakedata.Movies
import com.example.projetfilms.network.Genre
import com.example.projetfilms.ui.theme.ProjetFilmsTheme

@Composable
fun MovieCard(
    movie: Movies,
    modifier: Modifier = Modifier,
    toDetails: (Int) -> Unit,
    lesgenres: List<Genre>
) {
    val filterString = lesgenres.filter { (int, _) -> int in movie.genre }.map { it.name }
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
        isFavorite = movie.isFavorite
    )
}

@Preview
@Suppress("MagicNumber")
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
            lesgenres = emptyList()
        )
    }
}
