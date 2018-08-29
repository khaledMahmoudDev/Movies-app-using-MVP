package com.example.khaledmahmoud.movieappusingmvp.ui.mainUi

import io.reactivex.disposables.CompositeDisposable

class MainActivityPresenter: MainActivityMVPContract.MainActivityPresenterInterface {

    private val subscriptions = CompositeDisposable()
    private lateinit var view :MainActivityMVPContract.MainActivityViewInterface


    override fun subscribe() {
    }

    override fun unsubscribe() {

        subscriptions.clear()
    }


    override fun attach(view: MainActivityMVPContract.MainActivityViewInterface) {
        this.view = view
        view.showlistFragment()

    }

}