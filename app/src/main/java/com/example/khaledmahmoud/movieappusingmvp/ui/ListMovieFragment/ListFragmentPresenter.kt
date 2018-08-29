package com.example.khaledmahmoud.movieappusingmvp.ui.ListMovieFragment

import android.provider.SyncStateContract
import com.example.khaledmahmoud.movieappusingmvp.model.Movie
import com.example.khaledmahmoud.movieappusingmvp.model.MovieResult
import com.example.khaledmahmoud.movieappusingmvp.network.Api
import com.example.khaledmahmoud.movieappusingmvp.util.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*

class ListFragmentPresenter : ListFragmentMVPContract.ListFragmentPresenterInterfce {

    private var subscreptin = CompositeDisposable()
    private val api: Api = Api.create()
    private lateinit var view: ListFragmentMVPContract.ListFragmentViewInterface


    override fun subscribe() {
    }

    override fun unsubscribe() {
        subscreptin.clear()
    }

    override fun attach(view: ListFragmentMVPContract.ListFragmentViewInterface) {

        this.view = view

    }

    override fun loadData() {
        var subscribe = api.getTopRatedMovies(Constants.API_KEY).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({t: MovieResult? ->
                    view.showProgress(false)
                    view.loadDataSuccess(t!!.results) }
                        , {error ->
                    view.showProgress(false)
                    view.showErrorMessage(error.localizedMessage)
                })
        subscreptin.add(subscribe)
    }


}

