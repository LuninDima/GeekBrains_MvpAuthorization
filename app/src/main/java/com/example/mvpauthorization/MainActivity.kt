package com.example.mvpauthorization

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpauthorization.mvpauthorization.UserAuthorizationScreen
import com.example.mvpauthorization.mvpusers.UsersScreen
import com.example.mvpauthorization.navigation.CustomNavigator

class MainActivity : AppCompatActivity() {
    private val navigator = CustomNavigator(activity = this, R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            App.instance.router.navigateTo(UserAuthorizationScreen)
        }
    }

    override fun onPause() {
        App.instance.navigatorHolder.removeNavigator()
        super.onPause()
    }
}