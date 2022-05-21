package okladnikov.bool.iot_laboratory_app.data.user.source

import okladnikov.bool.iot_laboratory_app.data.user.UserModel

interface UserDataSource {
    suspend fun getUser(login: String, password: String) : UserModel
}