package okladnikov.bool.iot_laboratory_app.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.cookies.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import okladnikov.bool.iot_laboratory_app.model.DeviceModel
import okladnikov.bool.iot_laboratory_app.model.HouseModel
import org.json.JSONObject
import org.json.JSONTokener

private const val BASE_URL = "https://r-ho.in/"

suspend fun getHubs(userCookies: String): List<HouseModel> {

    val client = HttpClient() {
    }

    val privateCookieValue = userCookies.substringAfter("%3D%3D")
    val userCookieValue = userCookies.substringBefore("%3D%3D") + "%3D%3D"

    val response: HttpResponse = client.get(BASE_URL+"portal/api/hubs.get.bounded.php") {
        cookie(
            name = "Private",
            value = privateCookieValue,
            domain = "r-ho.in",
            path = "/"
        )
        cookie(
            name = "user",
            value = userCookieValue,
            domain = "r-ho.in",
            path = "/"
        )
    }

    client.close()

    val jsonObject = JSONTokener(response.body()).nextValue() as JSONObject
    val jsonResponse = jsonObject.getJSONObject("responce")
    val jsonArray = jsonResponse.getJSONArray("data")
    var houseModelList: List<HouseModel> = emptyList()

    for (i in 0 until jsonArray.length()) {
        val id = jsonArray.getJSONObject(i).getString("id")
        val name = jsonArray.getJSONObject(i).getString("name")
        val isOnline = jsonArray.getJSONObject(i).getBoolean("isOnline")
        houseModelList = houseModelList + HouseModel(name, id, isOnline)
    }

    return houseModelList
}

suspend fun getUnits(userCookies: String): List<DeviceModel> {
    val client = HttpClient() {
        install(HttpCookies)
    }

    val userCookieValue = userCookies.substringBefore("%3D%3D") + "%3D%3D"
    val hubIDCookie = userCookies.substringAfter("%2D%2D")
    val privateCookieValue = userCookies.substringAfter("%3D%3D").substringBefore("%2D%2D")

    client.get(BASE_URL+"portal/api/hubs.get.bounded.php") {
        cookie(
            name = "Private",
            value = privateCookieValue,
            domain = "r-ho.in",
            path = "/"
        )
        cookie(
            name = "user",
            value = userCookieValue,
            domain = "r-ho.in",
            path = "/"
        )
    }
    client.get(BASE_URL+"portal/api/hubs.bound.select.php?id=${hubIDCookie}") {
        cookie(
            name = "Private",
            value = privateCookieValue,
            domain = "r-ho.in",
            path = "/"
        )
        cookie(
            name = "user",
            value = userCookieValue,
            domain = "r-ho.in",
            path = "/"
        )
    }
    client.get(BASE_URL+"portal/api/hubs.get.bounded.php") {
        cookie(
            name = "Private",
            value = privateCookieValue,
            domain = "r-ho.in",
            path = "/"
        )
        cookie(
            name = "user",
            value = userCookieValue,
            domain = "r-ho.in",
            path = "/"
        )
    }

    var response: HttpResponse = client.get(BASE_URL+"portal/api/units.get.all.php") {
        cookie(
            name = "Private",
            value = privateCookieValue,
            domain = "r-ho.in",
            path = "/"
        )
        cookie(
            name = "user",
            value = userCookieValue,
            domain = "r-ho.in",
            path = "/"
        )
    }

    client.close()

    var deviceModelList: List<DeviceModel> = emptyList()
    val jsonObject = JSONTokener(response.body()).nextValue() as JSONObject
    val jsonResponse = jsonObject.getJSONObject("responce")
    val jsonData = jsonResponse.getJSONObject("data")
    val jsonArrayUnits = jsonData.getJSONArray("units")

    for (i in 0 until jsonArrayUnits.length()) {
        val name = jsonArrayUnits.getJSONObject(i).getString("name")
        val lastValue = jsonArrayUnits.getJSONObject(i).getString("lastValue")
        val lastTime = jsonArrayUnits.getJSONObject(i).getString("lastTime")
        val possValues = jsonArrayUnits.getJSONObject(i).getString("possValues")
        val iconUrl = jsonArrayUnits.getJSONObject(i).getString("icon")
        deviceModelList = deviceModelList + DeviceModel(
            name = name,
            lastValue = lastValue,
            lastTime = lastTime,
            possValues = possValues,
            iconUrl = iconUrl
        )
    }

    return deviceModelList
}