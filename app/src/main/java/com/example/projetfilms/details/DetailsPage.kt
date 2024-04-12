package com.example.projetfilms.details

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.projetfilms.ui.theme.ProjetFilmsTheme
import com.example.projetfilms.viewModel.DetailsViewModel
import com.example.projetfilms.viewModel.ListViewModel

@Composable
fun DetailsPage(backTo: () -> Unit, id: Int, viewModel: DetailsViewModel?) {
    viewModel?.let { vuModel ->

        vuModel.getMovieById(id)
        val movie by viewModel.movieDetails.collectAsState()


        val painter =
            rememberAsyncImagePainter(model = "https://image.tmdb.org/t/p/w1280${movie?.poster}")
        movie?.let {
            val lesGenres = it.genres.joinToString(separator = ", ") { genre ->
                genre.name
            }
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                IconButton(onClick = backTo) {
                    Icon(imageVector = Icons.Outlined.ArrowBack, "Back")
                }
                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .fillMaxWidth(0.6f)
                        .aspectRatio(ratio = 2 / 3f),
                )
                Column(modifier = Modifier.absolutePadding(left = 24.dp)) {
                    Spacer(Modifier.size(24.dp))
                    InfosMovie(movie = it,genres = lesGenres)
                    Spacer(Modifier.size(24.dp))
                    Buttons()
                    Spacer(Modifier.size(24.dp))
                    Overview(movie = it)
                }
                Spacer(Modifier.size(24.dp))
                //            ActorsCarrousel(movie.actors)
                Spacer(Modifier.size(24.dp))
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