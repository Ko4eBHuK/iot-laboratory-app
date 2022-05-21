package okladnikov.bool.iot_laboratory_app.data.hub.source

import okladnikov.bool.iot_laboratory_app.data.hub.HubModel

class DefaultHubRepository : HubRepository {
    override suspend fun getHubFromRemoteDataSource(): HubModel {
        TODO("Not yet implemented")
    }
}