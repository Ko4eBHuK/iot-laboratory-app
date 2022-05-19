package okladnikov.bool.iot_laboratory_app.model

import kotlinx.serialization.Serializable

@Serializable
data class HouseModel(
    val name: String,
    val id: String,
    val isOnline: Boolean
)
