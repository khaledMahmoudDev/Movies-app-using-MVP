package com.example.khaledmahmoud.movieappusingmvp.di.module

import com.example.khaledmahmoud.movieappusingmvp.network.Api
import com.example.khaledmahmoud.movieappusingmvp.ui.ListMovieFragment.ListFragmentMVPContract
import com.example.khaledmahmoud.movieappusingmvp.ui.ListMovieFragment.ListFragmentPresenter
import com.example.khaledmahmoud.movieappusingmvp.ui.detailMovieFragment.DetailFragmentPresenter
import com.example.khaledmahmoud.movieappusingmvp.ui.detailMovieFragment.DetailMVPContract
import dagger.Module
import dagger.Provides


@Module
class FragmentModule {


    @Provides
    fun provideListPresenter(): ListFragmentMVPContract.ListFragmentPresenterInterfce = ListFragmentPresenter()

    @Provides
    fun PrivideDetailPresenter(): DetailMVPContract.DeatailPresenterInterface = DetailFragmentPresenter()


    @Provides
    fun provideApiService(): Api = Api.create()



}