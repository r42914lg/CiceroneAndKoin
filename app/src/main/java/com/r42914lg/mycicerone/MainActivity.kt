package com.r42914lg.mycicerone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {

    private val navigator = AppNavigator(this, R.id.fragment_container_view)

    override fun onResumeFragments() {
        super.onResumeFragments()
        MyApp.INSTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        MyApp.INSTANCE.navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApp.INSTANCE.router.navigateTo(Screens.FragmentOne("Splash screen..."))
    }
}