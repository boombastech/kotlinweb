package uk.co.boombastech.kotlinweb.http.authentication

interface ActiveUserService {
    fun isActiveUser(userId: String): Boolean
    fun addUser(userId: String)
}

class ActiveUserServiceImpl : ActiveUserService {
    val activeUsers: MutableList<String> = mutableListOf()

    override fun addUser(userId: String) {
        activeUsers.add(userId)
    }

    override fun isActiveUser(userId: String): Boolean {
        return activeUsers.contains(userId)
    }
}