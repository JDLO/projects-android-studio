package com.example.composeactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeactivity.ui.theme.ComposeActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeActivityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BookShopView()
                }
            }
        }
    }
}
@Composable
fun BookShopView(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
    ) {
        val imageBackground = painterResource(R.drawable.bg_compose_background)

        Image(painter = imageBackground, contentDescription = null)
        BookShopTitle(stringResource(R.string.title_jetpack_compose_tutorial))
        BookShopShortDesc(stringResource(R.string.compose_short_desc))
        BookShopLongDesc(stringResource(R.string.compose_long_desc))
    }
}

@Composable
fun BookShopTitle(title: String){
    Text(
        text = title,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(16.dp)
    )
}

@Composable
fun BookShopShortDesc(desc: String){
    Text(
        text = desc,
        fontSize = 16.sp,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp),
        textAlign = TextAlign.Justify
    )
}

@Composable
fun BookShopLongDesc(desc: String){
    Text(
        text = desc,
        fontSize = 16.sp,
        modifier = Modifier
            .padding(16.dp),
        textAlign = TextAlign.Justify
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeActivityTheme {
        BookShopView()
    }
}