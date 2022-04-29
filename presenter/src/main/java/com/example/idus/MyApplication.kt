package com.example.idus

import android.app.Application
import com.example.idus.di.AppComponent
import com.example.idus.di.DaggerAppComponent

class MyApplication : Application() {

    val appComponent: AppComponent by lazy {

        DaggerAppComponent.factory().create(applicationContext)

    }

}