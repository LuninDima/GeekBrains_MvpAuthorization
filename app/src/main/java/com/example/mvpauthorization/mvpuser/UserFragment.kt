package com.example.mvpauthorization.mvpuser

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.mvpauthorization.R
import com.example.mvpauthorization.databinding.ViewUserBinding
import moxy.MvpAppCompatFragment


class UserFragment : MvpAppCompatFragment(R.layout.view_user), UserView {

    private lateinit var viewBinding: ViewUserBinding

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = ViewUserBinding.bind(view)
        showGreatingUser(userLogin)
    }

    override fun showGreatingUser(userLogin: String) {
        viewBinding.userLogin.text = String.format("%s, %s", "Добро пожаловать", userLogin)
    }

    companion object {
        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userLogin: String): Fragment =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER_LOGIN, userLogin)
                }
            }
    }
}