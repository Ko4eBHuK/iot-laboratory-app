package okladnikov.bool.iot_laboratory_app.ui.elements

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavController

@Composable
fun DefaultBottomNavigationBar(
    navController: NavController,
    userCookie: Boolean
) {
    var infoTabSelected by rememberSaveable { mutableStateOf(true) }
    var houseTabSelected by rememberSaveable { mutableStateOf(false) }
    var accountTabSelected by rememberSaveable { mutableStateOf(false) }

    BottomNavigation {
        BottomNavigationItem(
            selected = infoTabSelected,
            onClick = {
                infoTabSelected = true
                houseTabSelected = false
                accountTabSelected = false
                navController.navigate("info")
                      },
            label = { Text("Информация") },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "About App"
                )
            }
        )

        BottomNavigationItem(
            selected = houseTabSelected,
            onClick = {
                infoTabSelected = false
                houseTabSelected = true
                accountTabSelected = false
                navController.navigate("houseManage/$userCookie")
                      },
            label = { Text("Помещения") },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Hose management"
                )
            }
        )

        BottomNavigationItem(
            selected = accountTabSelected,
            onClick = {
                infoTabSelected = false
                houseTabSelected = false
                accountTabSelected = true
                navController.navigate("logReg/$userCookie")
                      },
            label = { Text("Профиль") },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Face,
                    contentDescription = "Account management"
                )
            }
        )
    }
}