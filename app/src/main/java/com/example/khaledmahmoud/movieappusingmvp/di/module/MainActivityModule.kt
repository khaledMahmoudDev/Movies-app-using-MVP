package com.example.khaledmahmoud.movieappusingmvp.di.module

import android.app.Activity
import com.example.khaledmahmoud.movieappusingmvp.ui.mainUi.MainActivityMVPContract
import com.example.khaledmahmoud.movieappusingmvp.ui.mainUi.MainActivityPresenter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule  (private var activity: Activity){

    @Provides
    fun provideActivity():Activity = this.activity

    @Provides
    fun providePresenter():MainActivityMVPContract.MainActivityPresenterInterface = MainActivityPresenter()






}