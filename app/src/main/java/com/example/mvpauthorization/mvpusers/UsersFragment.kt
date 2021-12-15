package com.example.mvpauthorization.mvpusers

import android.os.Bundle
import android.view.FrameMetrics
import android.view.View
import androidx.fragment.app.Fragment
import com.example.mvpauthorization.App
import com.example.mvpauthorization.R
import com.example.mvpauthorization.data.GitHubUser
import com.example.mvpauthorization.data.GitHubUserRepositoryFactory
import com.example.mvpauthorization.databinding.ViewUserBinding
import com.example.mvpauthorization.databinding.ViewUsersBinding
import com.example.mvpauthorization.recycler.UsersAdapter
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment: MvpAppCompatFragment(R.layout.view_users),
UsersView, UsersAdapter.OnUserClickListener{
    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            userRepository = GitHubUserRepositoryFactory.create(),
            router = App.instance.router
        )
    }
    private val usersAdapter = UsersAdapter(this)
    private lateinit var viewBinding: ViewUsersBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = ViewUsersBinding.bind(view)
        viewBinding.usersRecycler.adapter = usersAdapter
    }


    override fun showUsers(users: List<GitHubUser>) {
        usersAdapter.submitList(users)
    }

    override fun onUserPicked(user: GitHubUser) = presenter.displayUser(user)

    companion object{
        fun newInstance(): Fragment = UsersFragment()
    }
}