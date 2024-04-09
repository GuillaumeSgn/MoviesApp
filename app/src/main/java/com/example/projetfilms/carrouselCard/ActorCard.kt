package com.example.projetfilms.carrouselCard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.projetfilms.R
import com.example.projetfilms.fakedata.Actor

@Composable
fun ActorCard(actor: Actor, modifier: Modifier = Modifier) {
    CustomCard(
        image = painterResource(id = R.drawable.acteur),
        title = actor.name,
        subtitle = actor.role,
        modifier = modifier.width(150.dp),
        isMovie = false
    )
}