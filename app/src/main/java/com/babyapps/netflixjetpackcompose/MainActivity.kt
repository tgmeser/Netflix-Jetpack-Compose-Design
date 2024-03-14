package com.babyapps.netflixjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.babyapps.netflixjetpackcompose.ui.theme.NetflixJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetflixJetpackComposeTheme {
                NetflixHomeScreen()
            }
        }
    }
}

@Composable
@Preview
fun NetflixHomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
    ) {
        ToolbarView()
        SectionView()
        FeaturedContent()
        OtherContentsView()
    }
}

@Composable
@Preview
fun ToolbarView() {
    Row(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .padding(top = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Netflix logo
        Image(
            painter = painterResource(id = R.drawable.netflix_logo),
            contentDescription = "netflix_logo",
            Modifier.size(35.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.search_icon),
                contentDescription = "search",
                Modifier
                    .size(30.dp)
                    .padding(2.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "Popeye",
                Modifier
                    .size(50.dp)
                    .padding(8.dp)
            )
        }

    }
}

@Composable
@Preview
fun SectionView() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "TV Shows", color = Color.LightGray, fontSize = 20.sp)
        Text(text = "Movies", color = Color.LightGray, fontSize = 20.sp)
        Row() {
            Text(text = "Categories", color = Color.LightGray, fontSize = 20.sp)
            Image(
                modifier = Modifier
                    .size(30.dp)
                    .padding(6.dp),
                painter = painterResource(id = R.drawable.dropdown_icon),
                contentDescription = "dropdown"
            )
        }
    }
}

@Composable
@Preview
fun FeaturedContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
    ) {
        // Cover Image
        Image(
            painter = painterResource(id = R.drawable.fightclub_cover),
            contentDescription = "Fight Club"
        )

        // Content detail
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Violence", color = Color.White, fontSize = 18.sp)
            Text(text = "Consumerism", color = Color.White, fontSize = 18.sp)
            Text(text = "Greed", color = Color.White, fontSize = 18.sp)
        }

        // Events
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 26.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = "Add Icon",
                    Modifier.size(36.dp)
                )
                Text(text = "Add to List", color = Color.White)
            }
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(text = "Play", fontWeight = FontWeight.W400, color = Color.Black, fontSize = 20.sp)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.info_icon),
                    contentDescription = "Info Icon",
                    Modifier.size(20.dp).padding(top = 8.dp)
                )
                Text(text = "Info", color = Color.White, modifier = Modifier.padding(top = 10.dp))
            }
        }
    }
}

@Composable
fun OtherContentsView() {
    Column {
        Text(
            text = "Recently Added",
            color = Color.LightGray,
            fontSize = 24.sp,
            modifier = Modifier.padding(6.dp)
        )
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            itemsIndexed(setCoverPhoto()) { index,
                                            item ->
                scrollUiModel(imageRes = item.image)
            }
        }
    }
}

@Composable
//    @Preview
fun scrollUiModel(
    imageRes: Int
) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        modifier = Modifier
            .height(180.dp)
            .width(132.dp)
    )
}

fun setCoverPhoto(): List<ContentItem> {
    var contentList = mutableListOf<ContentItem>()
    contentList.add(ContentItem(R.drawable.batman_begins_cover))
    contentList.add(ContentItem(R.drawable.lotr_1_cover))
    contentList.add(ContentItem(R.drawable.lotr_2_cover))
    contentList.add(ContentItem(R.drawable.lotr_3_cover))
    contentList.add(ContentItem(R.drawable.batman_dark_knight_cover))
    contentList.add(ContentItem(R.drawable.better_call_saul_cover))
    contentList.add(ContentItem(R.drawable.john_wick_2_cover))
    contentList.add(ContentItem(R.drawable.john_wick_3_cover))

    contentList.shuffle()
    return contentList
}
