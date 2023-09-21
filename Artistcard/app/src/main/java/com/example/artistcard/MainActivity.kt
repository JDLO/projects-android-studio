package com.example.artistcard

import android.app.appsearch.SearchResult
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                    ArtisCard("Android")
                }
            }
        }
    }
}
class Artist(name: String, lastConection: String){
    var name: String = ""
    var lastConection: String = ""

    fun bothInformation(): String{
        return  this.name + " " + this.lastConection
    }
}

@Composable
fun SearchResult(){
    val artista = Artist("Alfredo Dias", "3 min Ago")

}

@Composable
fun ArtisCard(
        artist: Artist,
        modifier: Modifier = Modifier
    ) {
    Row(){
        Column {
            Image(painter = R.drawable.ic_launcher_foreground, contentDescription = null)
            Text(
                text = artist.name,
            )
            Text(
                text = artist.lastConection,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtistCardTheme {
        ArtisCard("Android")
    }
}