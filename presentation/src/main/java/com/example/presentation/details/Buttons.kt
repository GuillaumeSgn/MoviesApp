package com.example.presentation.details

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.theme.GreenBorder
import com.example.presentation.theme.ProjetFilmsTheme
import com.example.presentation.theme.RedBorder

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Buttons() {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(right = 20.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        CustomButton(
            imageVector = Icons.Filled.Download,
            color = GreenBorder,
            text = stringResource(id = R.string.download_button)
        )
        CustomButton(
            imageVector = Icons.Outlined.Share,
            color = GreenBorder,
            text = stringResource(id = R.string.share_button)
        )
        CustomButton(
            imageVector = Icons.Filled.FavoriteBorder,
            color = RedBorder,
            text = stringResource(id = R.string.favorite_button)
        )
    }
}

@Composable
fun CustomButton(imageVector: ImageVector, color: Color, text: String) {
    TextButton(
        onClick = {},
        modifier = Modifier
            .border(
                width = 1.dp,
                color = color,
                shape = RoundedCornerShape(size = 8.dp)
            )
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@Preview
@Composable
fun PreviewButton() {
    ProjetFilmsTheme {
        Buttons()
    }
}
