package com.example.mvpauthorization.mvpauthorization

import com.example.mvpauthorization.data.GitHubUser
import com.example.mvpauthorization.data.GitHubUserRepository
import com.example.mvpauthorization.data.GitHubUserRepositoryImpl
import com.example.mvpauthorization.mvpuser.UserScreen
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserAuthorizationPresenter(private val router: Router
):MvpPresenter<UserAuthorizationView>() {

    fun displayUser(userLogin: String) =
        router.navigateTo(UserScreen(userLogin))

    fun registerUser(user: GitHubUser) =
        GitHubUserRepositoryImpl().addUser(user)
}