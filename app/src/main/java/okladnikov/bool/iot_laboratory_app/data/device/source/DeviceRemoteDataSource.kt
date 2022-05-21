package okladnikov.bool.iot_laboratory_app.data.device.source

import io.ktor.client.request.forms.*
import io.ktor.http.*
import okladnikov.bool.iot_laboratory_app.data.device.DeviceModel

import okladnikov.bool.iot_laboratory_app.data.user.UserModel


class DeviceRemoteDataSource : DeviceDataSource {
    private val baseUrl = "https://r-ho.in/"

    // TODO - this fun
    override suspend fun getDevice(): DeviceModel {
        val device = DeviceModel(
            "",
            "",
            "",
            "",
            ""
        )

        return device
    }
}