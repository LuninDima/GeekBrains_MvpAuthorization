package com.example.mvpauthorization.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.ListAdapter
import com.example.mvpauthorization.data.GitHubUser
import com.example.mvpauthorization.databinding.ViewUserBinding

class UsersAdapter(private val onUserClickListener: OnUserClickListener?):
ListAdapter<GitHubUser, UserViewHolder>(UserDiff()) {

    interface OnUserClickListener {
        fun onUserPicked(user: GitHubUser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            UserViewHolder {
        val itemBinding = ViewUserBinding.inflate(LayoutInflater.from(parent.context))
        return UserViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position), onUserClickListener)
    }

}