package okladnikov.bool.iot_laboratory_app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultBottomAppBar

@Preview
@Composable
fun StartScreen() {
    Scaffold(
        bottomBar = {
            DefaultBottomAppBar()
        }
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {


            Card() {
                Text(text = "App info")
            }
        }
    }
}