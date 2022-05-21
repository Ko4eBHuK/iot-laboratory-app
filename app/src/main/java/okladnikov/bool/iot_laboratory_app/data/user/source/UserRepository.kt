package okladnikov.bool.iot_laboratory_app.data.user.source

import okladnikov.bool.iot_laboratory_app.data.user.UserModel

interface UserRepository {
    suspend fun getUserFromRemoteDataSource(login: String, password: String) : UserModel
}