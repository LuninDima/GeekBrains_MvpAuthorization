package com.example.mvpauthorization.mvpusers

import com.example.mvpauthorization.App
import com.example.mvpauthorization.data.GitHubUser
import com.example.mvpauthorization.data.GitHubUserRepository
import com.example.mvpauthorization.mvpuser.UserScreen
import com.example.mvpauthorization.navigation.CustomRouter
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: Router
): MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        userRepository
            .getUsers()
            .let(viewState::showUsers)
    }

    fun displayUser(user: GitHubUser) =
        router.navigateTo(UserScreen(user.login))

}
