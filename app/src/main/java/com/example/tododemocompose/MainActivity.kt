package com.example.tododemocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tododemocompose.ui.theme.ToDoDemoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoDemoComposeTheme {
                HomeScreen()
            }
        }
    }
}


@Composable
fun HomeScreen(){
    Text(
        text = "Home Page"
    )
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        HomeScreen()
    }
}