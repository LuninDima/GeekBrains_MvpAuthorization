package com.example.mvpauthorization.mvpuser

import com.example.mvpauthorization.data.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState


interface UserView:MvpView {
    @SingleState
    fun showGreatingUser(userLogin: String)
}