package okladnikov.bool.iot_laboratory_app.model

data class DeviceModel (
    val name: String,
    var lastValue: String,
    val possValues: String,
    val iconUrl: String,
    val id: String
)