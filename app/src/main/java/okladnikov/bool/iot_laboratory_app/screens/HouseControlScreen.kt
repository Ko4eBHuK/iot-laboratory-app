package okladnikov.bool.iot_laboratory_app.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okladnikov.bool.iot_laboratory_app.model.DeviceModel
import okladnikov.bool.iot_laboratory_app.network.getUnits
import okladnikov.bool.iot_laboratory_app.network.setDeviceState
import okladnikov.bool.iot_laboratory_app.ui.elements.CardWithTitle
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
                                Row {
                                    AsyncImage(
                                        model = device.iconUrl,
                                        contentDescription = "Icon",
                                        modifier = Modifier.size(64.dp))
                                    Column(
                                        modifier = Modifier.padding(8.dp),
                                        verticalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = "Состояние: ${if(device.lastValue == "0") "Выключено" else "Включено"}",
                                            color = MaterialTheme.colors.onPrimary
                                        )
                                        if(
                                            device.possValues.length -
                                            device.possValues.replace(",", "").length
                                            == 1) {
                                            Text(
                                                text = "-Переключить-",
                                                color = MaterialTheme.colors.onPrimary,
                                                modifier = Modifier.clickable {
                                                    if(device.lastValue ==
                                                        device.possValues.substringBefore(",")) {
                                                        device.lastValue =
                                                            device.possValues.substringAfter(",")
                                                    } else {
                                                        device.lastValue =
                                                            device.possValues.substringBefore(",")
                                                    }

                                                    runBlocking { setDeviceState(cookieString, device.id, device.lastValue) }
                                                }
                                            )
                                        } else {
                                            Text(
                                                text = "Возможные значения: ${device.possValues}",
                                                color = MaterialTheme.colors.onPrimary
                                            )
                                        }

                                        //TODO - implement control processes for devices with custom possValues
                                    }
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
