package com.thoughtworks.androidtrain.androidassignment.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.thoughtworks.androidtrain.androidassignment.R


@Composable
fun DiscoverScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (modifier = Modifier.padding(vertical = 2.dp)) {
            BoxItem(icon = R.drawable.moments, title = "Moments")
        }
        Column (modifier = Modifier.padding(vertical = 2.dp)) {
            BoxItem(icon = R.drawable.channels, title = "Channels")
            BoxItem(icon = R.drawable.live, title = "Live")
        }
        Column (modifier = Modifier.padding(vertical = 2.dp)) {
            BoxItem(icon = R.drawable.scan, title = "Scan")
            BoxItem(icon = R.drawable.listen, title = "Listen")
        }
    }
}

@Composable
private fun BoxItem(
    icon: Int,
    title: String
) {
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .height(60.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.fillMaxHeight()) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .padding(horizontal = 10.dp)
                    .align(Alignment.CenterVertically),
                imageVector = ImageVector.vectorResource(icon),
                contentDescription = ""
            )
            Text(modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically), text = title)
            Icon(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .align(Alignment.CenterVertically),
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = ""
            )
        }
    }
}