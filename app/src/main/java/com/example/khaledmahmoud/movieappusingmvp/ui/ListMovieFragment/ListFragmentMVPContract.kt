package com.example.khaledmahmoud.movieappusingmvp.ui.ListMovieFragment

import com.example.khaledmahmoud.movieappusingmvp.model.Movie
import com.example.khaledmahmoud.movieappusingmvp.ui.base.BaseContract

class ListFragmentMVPContract {


    interface ListFragmentPresenterInterfce : BaseContract.Presenter<ListFragmentViewInterface>{

        fun loadData()
    }

    interface ListFragmentViewInterface{
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(list: List<Movie>)
        }
}