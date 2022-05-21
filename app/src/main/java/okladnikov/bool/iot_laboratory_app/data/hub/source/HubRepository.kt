package okladnikov.bool.iot_laboratory_app.data.hub.source

import okladnikov.bool.iot_laboratory_app.data.hub.HubModel

interface HubRepository {
    // TODO - this fun
    suspend fun getHubFromRemoteDataSource() : HubModel
}