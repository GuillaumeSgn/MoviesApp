package com.example.presentation.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.model.Casting
import com.example.presentation.carrouselCard.ActorCard
import com.example.presentation.theme.ProjetFilmsTheme

@Composable
fun LineOfActor(
    actors: List<Casting?>,
    title: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.absolutePadding(left = 24.dp)
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineMedium)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = actors) { cast ->
                cast?.let {
                    it.takeIf { it.job == "Acting" }?.let { actor -> ActorCard(actor = actor) }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewLineOfActors() {
    ProjetFilmsTheme {
//        LineOfActor(actors = getActors(), title = "nom")
    }
}
