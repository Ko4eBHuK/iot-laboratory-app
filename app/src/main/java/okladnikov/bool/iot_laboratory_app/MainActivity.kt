package okladnikov.bool.iot_laboratory_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import okladnikov.bool.iot_laboratory_app.screens.StartScreen
import okladnikov.bool.iot_laboratory_app.ui.theme.IotlaboratoryappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IotlaboratoryappTheme {
                IotControlApp()
            }
        }
    }
}

@Preview
@Composable
fun IotControlApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        StartScreen()
    }
}
