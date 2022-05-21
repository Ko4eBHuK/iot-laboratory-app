package okladnikov.bool.iot_laboratory_app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import okladnikov.bool.iot_laboratory_app.model.HouseModel
import okladnikov.bool.iot_laboratory_app.network.getHubs
import okladnikov.bool.iot_laboratory_app.ui.elements.CardWithTitle
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultButton
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultTopAppBar
import okladnikov.bool.iot_laboratory_app.ui.theme.Blue

@Composable
fun HouseManageScreen(
    navController: NavController,
    cookieString: String
) {
    Scaffold(
        topBar = {
            DefaultTopAppBar("Доступные помещения")
        }
    ) {
        //TODO - fix crush of app when return to HouseManageScreen after it asked once before

        val coroutineScope = rememberCoroutineScope()
        var loadingElementVisibility by remember { mutableStateOf(true) }
        var houses: List<HouseModel>? by remember { mutableStateOf(null) }
        var calledOnce: Boolean by remember { mutableStateOf(false) }

        if(!calledOnce){
            calledOnce = true
            coroutineScope.launch {
                houses = getHubs(cookieString)
                loadingElementVisibility = false
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            item {
                Box{}
            }

            if(loadingElementVisibility){
                item {
                    CircularProgressIndicator(color = Blue)
                }
            } else {
                if(houses != null) {
                    items(houses!!) { house ->
                        CardWithTitle(title = "Помещение ${house.name}") {
                            Column() {
                                Text(
                                    text = if(house.isOnline) "Работает" else "Не работает",
                                    color = MaterialTheme.colors.onPrimary
                                )
                                Text(
                                    text = "ID: ${house.id}",
                                    color = MaterialTheme.colors.onPrimary
                                )
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    IconButton(onClick = {
                                        navController.navigate("houseControl/${house.id}")
                                    }) {
                                        Icon(
                                            imageVector = Icons.Filled.PlayArrow,
                                            contentDescription = "Control house",
                                            tint = MaterialTheme.colors.onPrimary
                                        )
                                    }

                                    IconButton(onClick = {

                                    }) {
                                        Icon(
                                            imageVector = Icons.Filled.Delete,
                                            contentDescription = "Delete house",
                                            tint = MaterialTheme.colors.onPrimary
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            item {
                DefaultButton(
                    onClick = {
                        navController.navigate("houseAdd")
                    },
                    text = "Привязать помещение",
                    modifier = Modifier.padding(bottom = 60.dp)
                )
            }
        }
    }
}

