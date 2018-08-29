package com.example.khaledmahmoud.movieappusingmvp.di.component

import com.example.khaledmahmoud.movieappusingmvp.di.module.MainActivityModule
import com.example.khaledmahmoud.movieappusingmvp.ui.mainUi.MainActivityView
import dagger.Component


@Component(modules = [(MainActivityModule::class)])
interface MainActivityComponent {

    fun inject(mainActivity : MainActivityView)

}