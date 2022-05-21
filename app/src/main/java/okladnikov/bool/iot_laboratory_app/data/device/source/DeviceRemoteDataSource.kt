package okladnikov.bool.iot_laboratory_app.data.device.source

import okladnikov.bool.iot_laboratory_app.data.device.DeviceModel


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