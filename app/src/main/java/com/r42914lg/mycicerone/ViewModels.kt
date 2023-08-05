package com.r42914lg.mycicerone

import android.content.Context
import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router

class FragOneViewModel(
    private val router: Router,
) : ViewModel() {

    fun onNextScreen() {
        router.navigateTo(Screens.fragmentTwo("Here I am from Fragment #1"))
    }
}

class FragTwoViewModel(
    private val router: Router,
    private val appCtx: Context,
) : ViewModel() {

    fun onNextScreen() {
        router.navigateTo(Screens.fragmentOne("Back from Fragment #2"))
    }

    fun onOtherActivity() {
        router.navigateTo(Screens.otherActivity(appCtx))
    }
}