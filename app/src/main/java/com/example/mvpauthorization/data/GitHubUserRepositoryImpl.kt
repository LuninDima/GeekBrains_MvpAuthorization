package com.example.mvpauthorization.data

class GitHubUserRepositoryImpl: GitHubUserRepository {
    private var users = mutableListOf(
        GitHubUser("login1",""),
        GitHubUser("login2",""),
        GitHubUser("login3",""),
        GitHubUser("login4",""),
        GitHubUser("login5",""),
    )
    private var user = listOf(
        GitHubUser("", "")
    )

    override fun getUsers() = users

    override fun getUserByLogin(userId: String): GitHubUser? =
        users.firstOrNull{user -> user.login == userId}

    override fun getUserByLoginPassword(login: String, passwoird: String) {
        TODO("Not yet implemented")
    }

    override fun addUser(user:GitHubUser) {
       users.add(user)}


}