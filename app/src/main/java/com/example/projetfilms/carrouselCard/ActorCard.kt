package com.example.projetfilms.carrouselCard

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.projetfilms.R
import com.example.projetfilms.fakedata.Actor

@Composable
fun ActorCard(actor: Actor, modifier: Modifier = Modifier) {
    CustomCard(
        image = painterResource(id = R.drawable.acteur),
        title = actor.name,
        subtitle = actor.role,
        func = {},
        modifier = modifier
    )
}