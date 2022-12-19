package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.destinations.HomeScreenDestination
import com.example.myapplication.destinations.Lab2ScreenDestination
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DestinationsNavHost(navGraph = NavGraphs.root)


                }
            }
        }
    }
}

@Destination(start = true)
@Composable
fun HomeScreen(navigator: DestinationsNavigator) {
    var value by remember { mutableStateOf("") }
    Column() {
        Text(text = "This is the home screen")
        Button(onClick = { navigator.navigate(Lab2ScreenDestination) }) {
            Text(text = "go to next")
        }
        TextField(value = value, onValueChange = { value = it })
        Button(onClick = { value = "" }) {
            Text(text = "clear")
        }
    }
}


    @Destination
    @Composable
    fun Lab2Screen(navigator: DestinationsNavigator) {
        Column() {
            Text(text = "This is the Lab 2 screen")
            Button(onClick = { navigator.navigate(HomeScreenDestination) }) {
                Text(text = "go to home")
            }
        }
    }



