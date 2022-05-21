package okladnikov.bool.iot_laboratory_app.data.device.source

import okladnikov.bool.iot_laboratory_app.data.device.DeviceModel

class DefaultDeviceRepository(
    private val deviceRemoteDataSource: DeviceDataSource
) : DeviceRepository {
    // TODO - this fun
    override suspend fun getDeviceFromRemoteDataSource(): DeviceModel {
        return deviceRemoteDataSource.getDevice()
    }
}