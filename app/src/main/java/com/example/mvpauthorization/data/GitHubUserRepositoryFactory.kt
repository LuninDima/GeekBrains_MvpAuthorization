package com.example.mvpauthorization.data

object GitHubUserRepositoryFactory {
    fun create(): GitHubUserRepository = GitHubUserRepositoryImpl()
}