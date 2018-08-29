package com.example.khaledmahmoud.movieappusingmvp.di.module

import android.app.Application
import com.example.khaledmahmoud.movieappusingmvp.MyApp
import com.example.khaledmahmoud.movieappusingmvp.di.scope.PreApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule (private val baseApp: MyApp){

    @Provides
    @Singleton
    @PreApplication
    fun provideApplication(): Application = baseApp
}