package com.example.projetfilms.carrouselCard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetfilms.R
import com.example.projetfilms.fakedata.Movies
import com.example.projetfilms.ui.theme.ProjetFilmsTheme

@Composable
fun MovieCard(movie: Movies, modifier: Modifier = Modifier, toDetails: (Int) -> Unit) {
   CustomCard(image = painterResource(id = R.drawable.filmposter), title = movie.title, subtitle = movie.genre, modifier = modifier.clickable{ toDetails(movie.movieId) }.width(150.dp),isMovie = true )
}

@Preview
@Composable
private fun PreviewCard() {
    ProjetFilmsTheme {
        MovieCard(
            Movies(0, "title of the first movie", "synopsis ...", 87, "enfants", listOf(),"20/06/2020","90min"),
            toDetails = {})

    }
}