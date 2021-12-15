package com.example.mvpauthorization

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class App: Application() {
    companion object Navigation{
      lateinit var instance: App
        }
    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()

    }
    val navigatorHolder get() = cicerone.getNavigatorHolder()
    val router get() = cicerone.router

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}