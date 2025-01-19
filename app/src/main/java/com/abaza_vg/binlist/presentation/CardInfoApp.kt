package com.abaza_vg.binlist.presentation

import android.app.Application
import com.abaza_vg.binlist.data.di.DaggerAppComponent

class CardInfoApp: Application() {

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }
}