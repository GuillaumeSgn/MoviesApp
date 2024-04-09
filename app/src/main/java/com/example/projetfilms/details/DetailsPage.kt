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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetfilms.R
import com.example.projetfilms.fakedata.Movies
import com.example.projetfilms.fakedata.getMovieById
import com.example.projetfilms.ui.theme.ProjetFilmsTheme

@Composable
fun DetailsPage(backTo: () -> Unit, id: Int?) {
    val movie: Movies? = id?.let { getMovieById(it) }
    if (movie != null) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .absolutePadding(left = 24.dp)
        ) {
            IconButton(onClick = backTo) {
                Icon(imageVector = Icons.Outlined.ArrowBack, "Back")
            }
            Image(
                painter = painterResource(id = R.drawable.filmposter),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .fillMaxWidth(0.6f)
                    .aspectRatio(ratio = 2 / 3f),
            )
            Spacer(Modifier.size(24.dp))
            InfosMovie(movie = movie)
            Spacer(Modifier.size(24.dp))
            Buttons()
            Spacer(Modifier.size(24.dp))
            Overview(movie = movie)
            Spacer(Modifier.size(24.dp))
            ActorsCarrousel(movie.actors)
            Spacer(Modifier.size(24.dp))
        }
    }
}


@Preview
@Composable
private fun PreviewDetails() {
    ProjetFilmsTheme {
        DetailsPage(backTo = { }, id = 0)
    }
}