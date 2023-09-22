package com.example.artisshape

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artisshape.ui.theme.ArtisShapeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtisShapeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    View()
                }
            }
        }
    }
}

@Composable
fun View(){
    var foto by remember { mutableStateOf(1)}

    @Composable
    fun Vista(
        image: Int,
        @StringRes title: Int,
        @StringRes author: Int
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(stringResource(id = title))
            Text(stringResource(id = author))
            Row(){
                Button(onClick = { foto-=1 }) {
                    Text(text = "Previous")
                }
                Button(onClick = { foto+=1 }) {
                    Text(text = "Next")
                }
            }
        }
    }


    when(foto){
        0 -> {
            foto = 3
            Vista(
                R.drawable.pexels_dc_productions_10367456,
                R.string.amanecer_sobre_el_bosque,
                R.string.pexels
            )
        }
        1 -> Vista(
            R.drawable.pexels_dc_productions_10367456,
            R.string.amanecer_sobre_el_bosque,
            R.string.pexels
        )
        2 -> Vista(
            R.drawable.pexels_eberhard_grossgasteiger_443446,
            R.string.lago_en_el_bosque,
            R.string.pexels
        )
        3 -> Vista(
            R.drawable.pexels_eberhard_grossgasteiger_454880,
            R.string.lago_al_pie_de_la_monta_a,
            R.string.pexels
        )
        4 -> {
            foto = 1
            Vista(
                R.drawable.pexels_eberhard_grossgasteiger_454880,
                R.string.lago_al_pie_de_la_monta_a,
                R.string.pexels
            )
        }

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtisShapeTheme {
        View()
    }
}