package com.example.khaledmahmoud.movieappusingmvp.di.component

import com.example.khaledmahmoud.movieappusingmvp.MyApp
import com.example.khaledmahmoud.movieappusingmvp.di.module.AppModule
import dagger.Component


@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(application : MyApp)


}