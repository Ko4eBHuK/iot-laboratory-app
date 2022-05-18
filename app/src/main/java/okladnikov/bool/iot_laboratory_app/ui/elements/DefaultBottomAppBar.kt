package okladnikov.bool.iot_laboratory_app.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun DefaultBottomAppBar(navController: NavController) {
    BottomAppBar() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = {
                navController.navigate("start")
            }) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "About App"
                )
            }

            IconButton(onClick = {
                navController.navigate("houseManage")
            }) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Hose management"
                )
            }

            IconButton(onClick = {
                navController.navigate("logReg")
            }) {
                Icon(
                    imageVector = Icons.Filled.Face,
                    contentDescription = "Account management"
                )
            }
        }
    }
}