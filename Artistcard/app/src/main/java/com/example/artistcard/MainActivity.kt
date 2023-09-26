package com.example.artistcard

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artistcard.ui.theme.ArtistCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtistCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}
class Artist(val name: String, val lastConection: String, val imageResource: Painter){

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Artist")
                },
                colors = TopAppBarDefaults
                    .smallTopAppBarColors(
                        containerColor = Color.Cyan,
                        titleContentColor = Color.White,
                        navigationIconContentColor = MaterialTheme
                            .colorScheme.onPrimaryContainer,
                        actionIconContentColor = MaterialTheme
                            .colorScheme.onPrimaryContainer
                )
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ){
            SearchResult()
        }
    }
}

@Composable
fun SearchResult(){
    val artista = Artist(
        "Alfredo Dias", 
        "3 min Ago", 
        painterResource(id = R.drawable._57856549_conjunto_de_vestido_periwig)
    )
    ArtisCard(artist = artista, painterResource(id = R.drawable.pintura), onClick = {})
}

@Composable
fun ArtisCard(
        artist: Artist,
        image: Painter,
        onClick: () -> Unit
    ) {
    var expanded by remember { mutableStateOf(false) }
    Column(
        Modifier
            .clickable(onClick = onClick)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Row(){
            ArtistAvatar(imageResource = artist.imageResource)
            Column (
                modifier = Modifier.padding(16.dp)
                    ) {
                Text(
                    text = artist.name,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = artist.lastConection,
                    fontSize = 12.sp,
                    color = Color(0xDDAFADAD)
                )
            }
        }
        Spacer(Modifier.size(16.dp))
        Card(
            modifier = Modifier.fillMaxWidth()
        ){
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .clickable { expanded = !expanded }
            )

        }
        if(expanded){
            Text(
                text = stringResource(id = R.string.app_name),
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun ArtistAvatar(imageResource: Painter){
    Box {
        Image(
            painter = imageResource,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Surface(
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.BottomEnd)
        ) {
            Icon(
                Icons.Default.Star,
                contentDescription = null,
            )
        }
    }
}

@Composable
fun OpenDescription(article: String){
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = {
        expanded = !expanded
    }) {
        Icon(imageVector = if (expanded)
            Icons.Filled.KeyboardArrowDown
        else Icons.Filled.KeyboardArrowUp,
            contentDescription = null)
    }

    if(expanded){
        Text(text = article)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtistCardTheme {
        HomeScreen()
    }
}

@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun Greeting2Preview() {
    ArtistCardTheme {
        HomeScreen()
    }
}