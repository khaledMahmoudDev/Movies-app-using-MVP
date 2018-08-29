package com.example.khaledmahmoud.movieappusingmvp.di.component

import com.example.khaledmahmoud.movieappusingmvp.di.module.FragmentModule
import com.example.khaledmahmoud.movieappusingmvp.ui.ListMovieFragment.ListFragmentVeiw
import com.example.khaledmahmoud.movieappusingmvp.ui.detailMovieFragment.DetailFragmentView
import dagger.Component


@Component(modules = [(FragmentModule::class)])
interface FragmentComponent {

    fun inject(listFragment: ListFragmentVeiw)

    fun inject(detailFragment: DetailFragmentView)

}