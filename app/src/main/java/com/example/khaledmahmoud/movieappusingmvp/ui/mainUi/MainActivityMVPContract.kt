package com.example.khaledmahmoud.movieappusingmvp.ui.mainUi

import com.example.khaledmahmoud.movieappusingmvp.ui.base.BaseContract

class MainActivityMVPContract {

    interface MainActivityViewInterface: BaseContract.View
    {
        fun showlistFragment()
        fun showDetailsFragment()

    }
    interface MainActivityPresenterInterface: BaseContract.Presenter<MainActivityMVPContract.MainActivityViewInterface>
    {



    }
}