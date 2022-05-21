package okladnikov.bool.iot_laboratory_app.data.device.source

import okladnikov.bool.iot_laboratory_app.data.device.DeviceModel

interface DeviceRepository {
    // TODO - this fun
    suspend fun getDeviceFromRemoteDataSource() : DeviceModel
}