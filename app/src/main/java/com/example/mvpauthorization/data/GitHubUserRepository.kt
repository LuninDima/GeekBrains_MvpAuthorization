package com.example.mvpauthorization.data

interface GitHubUserRepository {

    fun getUsers(): MutableList<GitHubUser>
    fun getUserByLogin(userId: String): GitHubUser?
    fun getUserByLoginPassword(login: String, passwoird: String)
    fun addUser(user: GitHubUser)
}