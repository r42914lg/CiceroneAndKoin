package com.r42914lg.mycicerone

import android.app.Application
import android.content.Context
import android.content.Intent
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MyApp : Application() {
    private val cicerone = Cicerone.create()

    val router
        get() = cicerone.router

    val navigatorHolder
        get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(appModule)
        }
    }

    companion object {
        internal lateinit var INSTANCE: MyApp
            private set
    }
}

object Screens {
    fun fragmentOne(title: String) = FragmentScreen { FragmentOne.newInstance(title) }
    fun fragmentTwo(text: String) = FragmentScreen { FragmentTwo.newInstance(text) }
    fun otherActivity(ctx: Context) = ActivityScreen { Intent(ctx, OtherActivity::class.java)  }
}