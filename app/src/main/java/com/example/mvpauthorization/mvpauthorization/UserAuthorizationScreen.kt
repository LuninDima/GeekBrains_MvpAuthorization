package com.example.mvpauthorization.mvpauthorization

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object UserAuthorizationScreen: FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment =
            UserAuthorizationFragment.newInstance()

    }