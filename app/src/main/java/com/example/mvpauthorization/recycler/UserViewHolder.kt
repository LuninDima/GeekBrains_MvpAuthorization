package com.example.mvpauthorization.recycler

import androidx.recyclerview.widget.RecyclerView
import com.example.mvpauthorization.data.GitHubUser
import com.example.mvpauthorization.databinding.ViewUserBinding

class UserViewHolder(private val viewBinding: ViewUserBinding):
RecyclerView.ViewHolder(viewBinding.root){

    fun bind(user: GitHubUser, onUserClickListener:
    UsersAdapter.OnUserClickListener?){
        viewBinding.userLogin.text = user.login
        viewBinding.root.setOnClickListener{
            onUserClickListener?.onUserPicked(user)
        }
    }
}