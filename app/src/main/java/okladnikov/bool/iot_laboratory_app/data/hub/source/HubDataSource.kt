package okladnikov.bool.iot_laboratory_app.data.hub.source

import okladnikov.bool.iot_laboratory_app.data.hub.HubModel

interface HubDataSource {
    // TODO - this fun
    suspend fun getHub() : HubModel
}