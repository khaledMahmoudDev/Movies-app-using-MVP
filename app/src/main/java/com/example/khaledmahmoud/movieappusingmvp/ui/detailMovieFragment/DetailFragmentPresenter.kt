package com.example.khaledmahmoud.movieappusingmvp.ui.detailMovieFragment

class DetailFragmentPresenter: DetailMVPContract.DeatailPresenterInterface {

    private lateinit var view: DetailMVPContract.DetailViewInterface

    override fun subscribe() {

    }

    override fun unsubscribe() {

    }

    override fun attach(view: DetailMVPContract.DetailViewInterface) {
        this.view = view
    }
}