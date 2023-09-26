package com.example.presentationofme


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentationofme.ui.theme.PresentationOfMeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PresentationOfMeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    All()
                }
            }
        }
    }
}

@Composable
fun All() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        FirstPart()
        Spacer(modifier = Modifier.weight(1f))
        SecondPart()
    }
}

@Composable
fun FirstPart(){
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imageResource = painterResource(R.drawable.android_logo)
        Image(
            painter = imageResource,
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .background(
                    Color(0xFDC8E9E9)
                )
        )
        TitlePresentation(title = stringResource(R.string.name_example))
        SubtitlePresentation(subtitle = stringResource(R.string.title_example))
    }
}

@Composable
fun SecondPart(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        DescriptionIcon(
            Icons.Default.Home,
            "Icon of home",
            description = stringResource(R.string.first_description)
        )
        DescriptionIcon(
            Icons.Default.Call,
            "Icon of call",
            description = stringResource(R.string.second_description)
        )
        DescriptionIcon(
            Icons.Default.Notifications,
            "Icon of notifications",
            description = stringResource(R.string.third_description)
        )
    }
}

@Composable
fun TitlePresentation(title: String){
    Text(
        text = title,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(
                top = 16.dp,
                bottom = 16.dp
            )
    )
}

@Composable
fun SubtitlePresentation(subtitle: String){
    Text(
        text = subtitle,
        fontSize = 16.sp
    )
}

@Composable
fun DescriptionIcon(icon: ImageVector, descIcon: String, description: String, modifier: Modifier = Modifier){
    Divider(
        color = Color.LightGray,
        thickness = 1.dp
    )
    Row(
        modifier = modifier.padding(10.dp)
    ){
        Icon(
            icon,
            contentDescription = descIcon,
            modifier = Modifier.padding(end = 5.dp)
        )
        Text(
            text = description
        )
    }
}

@Preview(showBackground = true, device = "id:pixel_6_pro")
@Composable
fun GreetingPreview() {
    PresentationOfMeTheme {
        All()
    }
}