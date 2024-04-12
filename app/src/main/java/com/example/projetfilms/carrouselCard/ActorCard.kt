package com.example.projetfilms.carrouselCard

import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetfilms.R
import com.example.projetfilms.fakedata.Actor
import com.example.projetfilms.fakedata.getActor
import com.example.projetfilms.ui.theme.ProjetFilmsTheme

@Composable
fun ActorCard(actor: Actor, modifier: Modifier = Modifier) {
    CustomCard(
        image = painterResource(id = R.drawable.acteur),
        title = actor.name,
        subtitle = actor.role,
        modifier = modifier.width(150.dp),
        isMovie = false,
    )
}

@Preview
@Composable
fun PreviewActorCard() {
    ProjetFilmsTheme {
        ActorCard(actor = getActor(0))
    }
}