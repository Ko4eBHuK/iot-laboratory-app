package okladnikov.bool.iot_laboratory_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import okladnikov.bool.iot_laboratory_app.screens.*
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultBottomNavigationBar
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
        var userCookie by rememberSaveable { mutableStateOf("") }
        var isUserLogged by rememberSaveable { mutableStateOf(false) }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(
                bottomBar = { DefaultBottomNavigationBar(navController = navController, isUserLogged) }
            ) {
                NavHost(
                    navController = navController,
                    startDestination = "info"
                ) {
                    composable("info") { StartScreen() }

                    composable("logOut") {
                        isUserLogged = false
                        StartScreen()
                    }

                    composable(
                        route = "logReg/{userLogged}",
                        arguments = listOf(
                            navArgument("userLogged") {
                                type = NavType.BoolType
                            }
                        )
                    ) { entry ->
                        val userLogged = entry.arguments?.getBoolean("userLogged")
                        if (userLogged != null) {
                            isUserLogged = userLogged
                            if(userLogged) AccountManageScreen(navController)
                            else LoginOrRegScreen(navController)
                        } else LoginOrRegScreen(navController)
                    }

                    composable("login") { LoginScreen(navController, userCookie) {
                        userCookie = it
                    }
                    }
                    composable("register") { RegisterScreen(navController) }
                    composable("accountManage") { AccountManageScreen(navController) }

                    composable(
                        route = "houseManage/{userLogged}",
                        arguments = listOf(
                            navArgument("userLogged") {
                                type = NavType.BoolType
                            }
                        )
                    ) { entry ->
                        val userLogged = entry.arguments?.getBoolean("userLogged")
                        if (userLogged != null) {
                            isUserLogged = userLogged
                            if(userLogged) HouseManageScreen(navController, userCookie)
                            else LoginOrRegScreen(navController)
                        } else LoginOrRegScreen(navController)
                    }

                    composable(
                        route = "houseControl/{hubID}",
                        arguments = listOf(
                            navArgument("hubID") {
                                type = NavType.IntType
                            }
                        )
                    ) { entry ->
                        val hubID = entry.arguments?.getInt("hubID")
                        if (hubID != null) {
                            userCookie += "%2D%2D$hubID"
                            HouseControlScreen(userCookie)
                        } else LoginOrRegScreen(navController)
                    }

                    composable("houseAdd") { HouseAddScreen(navController) }
                }
            }
        }
    }
}
