package okladnikov.bool.iot_laboratory_app.network

import io.ktor.client.*
import io.ktor.client.plugins.cookies.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*

private const val BASE_URL = "https://r-ho.in/"

suspend fun login(login: String, password: String) : String {
    val client = HttpClient() {
        install(HttpCookies)
    }

    client.get(BASE_URL)

    val params = Parameters.build {
        append("login", login)
        append("passw", password)
    }

    client.submitForm(BASE_URL + "portal/api/user.auth.login.php", params, false)

    var cookieString: String = ""
    client.cookies(BASE_URL).asReversed().forEach {
        cookie -> cookieString += cookie.value
    }

    client.close()

    return cookieString
}
