package okladnikov.bool.iot_laboratory_app.model

import kotlinx.serialization.Serializable

@Serializable
data class DeviceModel (
    val name: String,
    val lastValue: String,
    val lastTime: String,
    val possValues: String,
    val iconUrl: String
)