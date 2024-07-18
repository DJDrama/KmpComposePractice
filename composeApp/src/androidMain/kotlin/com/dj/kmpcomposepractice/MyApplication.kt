package com.dj.kmpcomposepractice

import android.app.Application
import di.initKoin
import org.koin.android.ext.koin.androidContext

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(androidContext = this@MyApplication)
        }
    }
}