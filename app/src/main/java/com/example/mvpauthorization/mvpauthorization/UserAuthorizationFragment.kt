package com.example.mvpauthorization.mvpauthorization

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.mvpauthorization.App
import com.example.mvpauthorization.R
import com.example.mvpauthorization.data.GitHubUser
import com.example.mvpauthorization.databinding.UserAuthorizationBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserAuthorizationFragment: MvpAppCompatFragment(R.layout.user_authorization), UserAuthorizationView {

    private lateinit var viewBinding: UserAuthorizationBinding
    private var  user: GitHubUser = GitHubUser("", "")
    private val presenter: UserAuthorizationPresenter by moxyPresenter {
        UserAuthorizationPresenter(
            router = App.instance.router
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = UserAuthorizationBinding.bind(view)
        user.login = ""
        user.password = ""
        viewBinding.buttonNext.setOnClickListener {
            user.login = viewBinding.editTextLogin.text.toString()
            user.password = viewBinding.editTextTextPassword.text.toString()
            presenter.displayUser(user.login)
            presenter.registerUser(user)

        }
    }

    companion object {
        fun newInstance(): Fragment = UserAuthorizationFragment()
    }
}