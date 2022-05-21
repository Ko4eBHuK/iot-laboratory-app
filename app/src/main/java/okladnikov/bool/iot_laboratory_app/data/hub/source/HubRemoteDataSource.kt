package okladnikov.bool.iot_laboratory_app.data.hub.source

import okladnikov.bool.iot_laboratory_app.data.hub.HubModel

class HubRemoteDataSource : HubDataSource {
    private val baseUrl = "https://r-ho.in/"

    override suspend fun getHub(): HubModel {
        TODO("Not yet implemented")
    }
}