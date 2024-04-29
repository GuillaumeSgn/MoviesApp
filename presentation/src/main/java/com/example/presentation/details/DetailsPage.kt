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
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.presentation.R
import com.example.presentation.theme.ProjetFilmsTheme

@Composable
@Suppress("MagicNumber")
fun DetailsPage(backTo: () -> Unit, id: Int, viewModel: DetailsViewModel?) {
    viewModel?.let { detailsViewModel ->
        val state by getData(detailsViewModel = detailsViewModel, id = id)

        GetEffect(viewModel = detailsViewModel, backTo)

        val painter =
            rememberAsyncImagePainter(model = "https://image.tmdb.org/t/p/w1280${state.movie?.poster}")
        state.movie?.let {
            val lesGenres = it.genres.joinToString(separator = ", ") { genre -> genre.name }
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                IconButton(onClick = backTo) {
                    Icon(imageVector = Icons.Outlined.ArrowBack, "Back")
                }
                if (state.poster) {
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
                    if (state.infosMovie) {
                        InfosMovie(movie = it, genres = lesGenres)
                    }
                    Spacer(Modifier.size(24.dp))
                    if (state.buttons) {
                        Buttons()
                    }
                    Spacer(Modifier.size(24.dp))
                    if (state.overview) {
                        Overview(movie = it)
                    }
                }
                Spacer(Modifier.size(24.dp))
                if (state.showActors) {
                    LineOfActor(
                        actors = state.actors,
                        title = stringResource(id = R.string.line_actors_title)
                    )
                }
                Spacer(Modifier.size(24.dp))
            }
        }
    }
}

@Composable
private fun getData(
    detailsViewModel: DetailsViewModel,
    id: Int
): State<DetailsReducer.DetailsViewState> {
    detailsViewModel.getActorsByMovieId(id)
    detailsViewModel.getMovieById(id)
    return detailsViewModel.state.collectAsState()
}

@Composable
private fun GetEffect(viewModel: DetailsViewModel, backTo: () -> Unit) {
    val effect = viewModel.effect
    LaunchedEffect(effect) {
        effect.collect { action ->
            when (action) {
                is DetailsReducer.DetailsViewEffect.BackToList -> backTo()
            }
        }
    }
}

@Preview
@Composable
private fun PreviewDetails() {
    ProjetFilmsTheme {
        DetailsPage(backTo = { }, id = 0, viewModel = null)
    }
}
