package com.example.projetfilms

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetfilms.fakedata.Movies
import com.example.projetfilms.ui.theme.ProjetFilmsTheme

@Composable
fun MovieCard(movie: Movies, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp), modifier = modifier.width(150.dp)) {
        Image(
            painter = painterResource(id = R.drawable.filmposter),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = 2 / 3f)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(text = movie.title, style = MaterialTheme.typography.titleSmall)
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = null,
                    tint = Color.Red
                )
                Text(text = movie.genre, style = MaterialTheme.typography.labelSmall)
            }
        }
    }

}

@Preview
@Composable
private fun PreviewCard() {
    ProjetFilmsTheme {
        MovieCard(Movies("title of the first movie", "synopsis ...", 87, "enfants"))

    }
}