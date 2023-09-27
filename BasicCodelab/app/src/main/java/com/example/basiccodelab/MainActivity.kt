package com.example.basiccodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccodelab.ui.theme.BasicCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCodelabTheme {
                // A surface container using the 'background' color from the theme
                Myapp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun Myapp(
    modifier: Modifier = Modifier
){
    Surface(
        modifier,
        color = MaterialTheme.colorScheme.background
    ) {

    }
}

@Composable
fun OnBoardingScreen(
    onContinueClicked: () -> Unit,

){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to codelab prros!!!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked,
            content = {}
        )
    }
}


@Preview(
    showBackground = true,
    widthDp = 320,
    heightDp = 320
)
@Composable
fun onBoardingPreview() {
    BasicCodelabTheme {
        OnBoardingScreen(onContinueClicked = {})
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    heightDp = 320
)
@Composable
fun MyAppPreview() {
    BasicCodelabTheme {
        Myapp()
    }
}