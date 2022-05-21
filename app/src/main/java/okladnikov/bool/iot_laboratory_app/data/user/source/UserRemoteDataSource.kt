package okladnikov.bool.iot_laboratory_app.data.user.source

import io.ktor.client.*
import io.ktor.client.plugins.cookies.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*

import okladnikov.bool.iot_laboratory_app.data.user.UserModel

class UserRemoteDataSource : UserDataSource {
    private val baseUrl = "https://r-ho.in/"

    override suspend fun getUser(login: String, password: String): UserModel {
        val client = HttpClient() {
            install(HttpCookies)
        }

        client.get(baseUrl)

        val params = Parameters.build {
            append("login", login)
            append("passw", password)
        }

        client.submitForm(baseUrl + "portal/api/user.auth.login.php", params, false)

        val user = UserModel("", "")

        if(client.cookies(baseUrl).size == 2){
            user.private = client.cookies(baseUrl)[0].value
            user.user = client.cookies(baseUrl)[1].value
        }

        client.close()

        return user
    }
}