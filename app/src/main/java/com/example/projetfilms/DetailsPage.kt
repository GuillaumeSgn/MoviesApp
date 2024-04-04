package com.example.projetfilms

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projetfilms.fakedata.Movies
import com.example.projetfilms.fakedata.getMovieById

@Composable
fun DetailsPage(backTo: () -> Unit, id: Int?) {
    val movie: Movies? = id?.let { getMovieById(it) }
    if (movie != null) {
        Column {
            IconButton(onClick = backTo) {
                Icon(imageVector = Icons.Outlined.ArrowBack, "Back", modifier = Modifier)
            }
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(text = "image du film")
                Text(
                    modifier = Modifier
                        .width(363.dp)
                        .height(68.dp),
                    text = movie.title,
                    style =
                    TextStyle(
                        fontSize = 26.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFEAEAEA),

                        )
                )
                Text(text = movie.rating.toString())
                Buttons()
                Text(text = "Overview")
                Text(text = movie.synopsis)
                Text(text = "Cast")
                Carousel()
            }
        }

    }
}


@Composable
fun Buttons() {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Button(
            onClick = {}, modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color(0xFF04BF8A),
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .width(111.dp)
                .height(40.dp)
                .padding(all = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.Download, "Download", modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
                    .padding(1.dp)
            )
            Text(
                text = "Download",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),
                )
            )
        }
        Button(
            onClick = {}, modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color(0xFF04BF8A),
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .width(84.dp)
                .height(40.dp)
                .padding(all = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.Share, "Share", modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            )
            Text(
                text = "Share",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),
                )
            )
        }
        Button(
            onClick = {},
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color(0xFFE70D41),
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .width(147.dp)
                .height(40.dp)
                .padding(all = 8.dp)
        )

        {
            Icon(
                imageVector = Icons.Outlined.Favorite,
                "Favorites",
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            )
            Text(
                text = "Add to favorites",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF)
                )
            )
        }
    }
}

@Composable
fun Carousel() {
    Row {
        Column {
            Text(text = "les photos")
        }
    }
}