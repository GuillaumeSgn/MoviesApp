package com.example.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.domain.model.Casting
import com.example.domain.model.MovieDetails
import com.example.presentation.R
import com.example.presentation.theme.ProjetFilmsTheme

@Composable
fun DetailsPage(backTo: () -> Unit, id: Int, viewModel: DetailsViewModel) {
    viewModel.apply {
        getActorsByMovieId(id)
        getMovieById(id)
        val state by state.collectAsState()

        val effect = effect
        LaunchedEffect(effect) {
            effect.collect { action ->
                when (action) {
                    is DetailsReducer.DetailsViewEffect.BackToList -> backTo()
                }
            }
        }

        val painter =
            rememberAsyncImagePainter(model = "https://image.tmdb.org/t/p/w1280${state.movie?.poster}")

        DetailsPageContent(
            backTo = backTo,
            movieDetails = state.movie,
            painter = painter,
            poster = state.poster,
            infosMovie = state.infosMovie,
            buttons = state.buttons,
            overview = state.overview,
            showActors = state.showActors,
            actors = state.actors
        )
    }
}

@Composable
@Suppress("MagicNumber")
private fun DetailsPageContent(
    backTo: () -> Unit,
    movieDetails: MovieDetails?,
    poster: Boolean,
    infosMovie: Boolean,
    buttons: Boolean,
    overview: Boolean,
    showActors: Boolean,
    actors: List<Casting>,
    painter: AsyncImagePainter
) {
    movieDetails?.apply {
        val lesGenres = genres.joinToString(separator = ", ") { genre -> genre.name }
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            IconButton(onClick = backTo) {
                Icon(imageVector = Icons.Outlined.ArrowBack, "Back")
            }
            if (poster) {
                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .fillMaxWidth(0.6f)
                        .aspectRatio(ratio = 2 / 3f),
                )
            }
            Column(modifier = Modifier.absolutePadding(left = 24.dp)) {
                Spacer(Modifier.size(24.dp))
                if (infosMovie) {
                    InfosMovie(movie = this@apply, genres = lesGenres)
                }
                Spacer(Modifier.size(24.dp))
                if (buttons) {
                    Buttons()
                }
                Spacer(Modifier.size(24.dp))
                if (overview) {
                    Overview(movie = this@apply)
                }
            }
            Spacer(Modifier.size(24.dp))
            if (showActors) {
                LineOfActor(
                    actors = actors,
                    title = stringResource(id = R.string.line_actors_title)
                )
            }
            Spacer(Modifier.size(24.dp))
        }
    }
}

@Preview
@Composable
private fun PreviewDetails() {
    ProjetFilmsTheme {
        DetailsPageContent(
            backTo = { },
            movieDetails = MovieDetails("truc", "truc", "truc", "truc", emptyList()),
            poster = true,
            infosMovie = true,
            buttons = true,
            overview = true,
            actors = emptyList(),
            showActors = true,
            painter = rememberAsyncImagePainter(model = "https://image.tmdb.org/t/p/w1280/1")
        )
    }
}
