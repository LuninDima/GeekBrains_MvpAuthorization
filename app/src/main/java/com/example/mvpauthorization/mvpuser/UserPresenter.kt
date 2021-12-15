package com.example.mvpauthorization.mvpuser

import com.example.mvpauthorization.data.GitHubUserRepository
import com.example.mvpauthorization.navigation.CustomRouter
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository,
    private val router: Router
):MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {

    }

}