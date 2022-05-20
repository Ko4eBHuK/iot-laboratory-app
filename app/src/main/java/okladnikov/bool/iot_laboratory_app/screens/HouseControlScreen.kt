package okladnikov.bool.iot_laboratory_app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import okladnikov.bool.iot_laboratory_app.model.DeviceModel
import okladnikov.bool.iot_laboratory_app.model.HouseModel
import okladnikov.bool.iot_laboratory_app.network.getHubs
import okladnikov.bool.iot_laboratory_app.network.getUnits
import okladnikov.bool.iot_laboratory_app.ui.elements.CardWithTitle
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultBottomNavigationBar
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultButton
import okladnikov.bool.iot_laboratory_app.ui.elements.DefaultTopAppBar
import okladnikov.bool.iot_laboratory_app.ui.theme.Blue

@Composable
fun HouseControlScreen(
    cookieString: String
) {
    Scaffold(
        topBar = {
            DefaultTopAppBar("Управление помещением")
        }
    ) {
        val coroutineScope = rememberCoroutineScope()
        var loadingElementVisibility by remember { mutableStateOf(true) }
        var devices: List<DeviceModel>? by remember { mutableStateOf(null) }
        var calledOnce: Boolean by remember { mutableStateOf(false) }

        if(!calledOnce){
            calledOnce = true
            coroutineScope.launch {
                devices = getUnits(cookieString)
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
                if(devices != null) {
                    items(devices!!) { device ->
                        Box(
                            modifier = Modifier.padding(10.dp)
                        ) {
                            CardWithTitle(title = "Устройство: ${device.name}") {
                                Column() {
                                    Text(
                                        text = "Последнее значение: ${device.lastValue}",
                                        color = MaterialTheme.colors.onPrimary
                                    )
                                    Text(
                                        text = "Последнее время доступа: ${device.lastTime}",
                                        color = MaterialTheme.colors.onPrimary
                                    )
                                    Text(
                                        text = "Возможные значения: ${device.possValues}",
                                        color = MaterialTheme.colors.onPrimary
                                    )
                                }
                            }
                        }
                    }
                }
            }

            item {
                Box(
                    modifier = Modifier.padding(bottom = 60.dp)
                )
            }
        }
    }
}
