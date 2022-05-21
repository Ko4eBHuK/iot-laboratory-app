package okladnikov.bool.iot_laboratory_app.data.user.source

import okladnikov.bool.iot_laboratory_app.data.user.UserModel

class DefaultUserRepository(
    private val userRemoteDataSource: UserDataSource
) : UserRepository {
    override suspend fun getUserFromRemoteDataSource(login: String, password: String): UserModel {
        return userRemoteDataSource.getUser(login, password)
    }
}