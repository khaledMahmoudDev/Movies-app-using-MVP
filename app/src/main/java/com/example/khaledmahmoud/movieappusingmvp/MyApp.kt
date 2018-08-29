package com.example.khaledmahmoud.movieappusingmvp

import android.app.Application
import com.example.khaledmahmoud.movieappusingmvp.di.component.AppComponent
import com.example.khaledmahmoud.movieappusingmvp.di.component.DaggerAppComponent
import com.example.khaledmahmoud.movieappusingmvp.di.module.AppModule

class MyApp : Application() {

    lateinit var compnent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        setup()
    }

    fun setup(){
        compnent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        compnent.inject(this)
    }

    companion object {
    lateinit var instance: MyApp private set
}
}