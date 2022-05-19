package okladnikov.bool.iot_laboratory_app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultBottomNavigationBar
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultButton
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultTopAppBar

@Composable
fun LoginOrRegScreen(navController: NavController) {
    Scaffold(
        topBar = {
            DefaultTopAppBar("Вход")
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.width(IntrinsicSize.Max),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DefaultButton(
                    onClick = {
                        navController.navigate("login")
                    },
                    text = "Войти",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )

                DefaultButton(
                    onClick = {
                        navController.navigate("register")
                    },
                    text = "Зарегестрироваться",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
            }
        }

    }
}
