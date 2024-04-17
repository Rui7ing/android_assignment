package com.thoughtworks.androidtrain.androidassignment.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.thoughtworks.androidtrain.androidassignment.data.dao.Tweet
import com.thoughtworks.androidtrain.androidassignment.data.dao.User
import com.thoughtworks.androidtrain.model.dao.Image

@Composable
fun MomentScreen(
    tweets: List<Tweet>?,
    user: User?,
) {
    Column(
        modifier = Modifier.verticalScroll(state = ScrollState(1), enabled = true)
    ) {
        tweets?.forEach { TweetItem(tweet = it) }
        BottomItem()
    }
}

@Composable
fun TweetItem(tweet: Tweet) {
    Row {
        AsyncImage(
            modifier = Modifier
                .padding(all = 5.dp)
                .size(60.dp),
            model = tweet.sender?.avatar,
            contentDescription = null
        )
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.padding(vertical = 5.dp),
                text = tweet.sender?.nick ?: "",
                fontSize = 20.sp,
                color = Color.Blue
            )
            Text(
                modifier = Modifier.padding(vertical = 2.dp),
                text = tweet.content ?: "",
                fontSize = 20.sp,
                color = Color.Black
            )
            ImageItem(tweet.images)
            Button(
                modifier = Modifier
                    .height(40.dp)
                    .width(70.dp)
                    .padding(5.dp)
                    .align(Alignment.End),
                onClick = { /*TODO*/ }
            ) {
                // 暂用这个icon
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "")
            }
        }
    }
}


@Composable
fun ImageItem(images: List<Image>?) {
    Row {
        images?.forEach {
            AsyncImage(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .height(100.dp)
                    .width(100.dp),
                contentScale = ContentScale.Crop,
                model = it.url,
                contentDescription = it.id.toString()
            )
        }
    }
}

@Composable
fun BottomItem() {

    Text(
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        text = "到底了",
        textAlign = TextAlign.Center
    )
}
