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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import okladnikov.bool.iot_laboratory_app.screens.*
import okladnikov.bool.iot_laboratory_app.ui.theme.IotlaboratoryappTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IotControlApp()
        }
    }
}

@Preview
@Composable
fun IotControlApp() {
    IotlaboratoryappTheme{
        val navController = rememberNavController()

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            NavHost(
                navController = navController,
                startDestination = "start"
            ) {
                composable("start") { StartScreen() }
                composable("logReg") { LoginOrRegScreen() }
                composable("login") { LoginScreen() }
                composable("register") { RegisterScreen() }
                composable("accountManage") { AccountManageScreen() }
                composable("houseManage") { HouseManageScreen() }
                composable("houseControl") { HouseControlScreen() }
                composable("houseAdd") { HouseAddScreen() }
            }

        }
    }
}
