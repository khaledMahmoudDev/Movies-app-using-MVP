package com.example.khaledmahmoud.movieappusingmvp.ui.detailMovieFragment

import android.graphics.Movie
import com.example.khaledmahmoud.movieappusingmvp.ui.base.BaseContract

class DetailMVPContract {

    interface DeatailPresenterInterface : BaseContract.Presenter<DetailViewInterface>{
    }

    interface DetailViewInterface: BaseContract.View
    {


        fun showProgress(show: Boolean)
        fun loadMessageSuccess(movie: com.example.khaledmahmoud.movieappusingmvp.model.Movie)

    }
}