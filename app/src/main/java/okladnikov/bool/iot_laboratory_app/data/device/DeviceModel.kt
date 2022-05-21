package okladnikov.bool.iot_laboratory_app.data.device

data class DeviceModel (
    val name: String,
    val lastValue: String,
    val lastTime: String,
    val possValues: String,
    val iconUrl: String
)