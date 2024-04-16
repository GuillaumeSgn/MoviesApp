package com.example.projetfilms.carrouselCard

import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.projetfilms.network.Casting
import com.example.projetfilms.ui.theme.ProjetFilmsTheme

@Composable
fun ActorCard(actor: Casting, modifier: Modifier = Modifier) {
    val painter =
        rememberAsyncImagePainter(model = "https://image.tmdb.org/t/p/w1280${actor.picture}")
    CustomCard(
        image = painter,
        title = actor.name,
        subtitle = actor.character,
        modifier = modifier.width(150.dp),
        isMovie = false,
        isFavorite = false
    )
}

@Preview
@Composable
fun PreviewActorCard() {
    ProjetFilmsTheme {
        ActorCard(actor = Casting(name = "bla", picture = "blah", character = "blah", job = "blah"))
    }
}
