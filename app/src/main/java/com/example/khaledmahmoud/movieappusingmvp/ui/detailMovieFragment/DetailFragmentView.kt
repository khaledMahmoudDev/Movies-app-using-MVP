package com.example.khaledmahmoud.movieappusingmvp.ui.detailMovieFragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.khaledmahmoud.movieappusingmvp.R
import com.example.khaledmahmoud.movieappusingmvp.di.component.DaggerFragmentComponent
import com.example.khaledmahmoud.movieappusingmvp.di.module.FragmentModule
import com.example.khaledmahmoud.movieappusingmvp.model.Movie
import kotlinx.android.synthetic.main.activity_details.*
import javax.inject.Inject

class DetailFragmentView : DetailMVPContract.DetailViewInterface,Fragment(){





    override fun loadMessageSuccess(movie: Movie) {

    }

    override fun showProgress(show: Boolean) {
    }

    @Inject lateinit var presenter: DetailMVPContract.DeatailPresenterInterface
    private lateinit var rootView: View


    fun newInstance():DetailFragmentView{
        return DetailFragmentView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.activity_details,container,false)
        return rootView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.subscribe()
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }


    private fun injectDependency()
    {

        val detailFragmentView = DaggerFragmentComponent.builder().fragmentModule(FragmentModule()).build()
        detailFragmentView.inject(this)
    }


    private fun initView(){
        val arg = arguments
        val mMovie = arg!!.getSerializable("movie") as Movie

        Glide.with(this).load("http://image.tmdb.org/t/p/w185/${mMovie.poster_path}")
                .into(detailsImageViewIV)

        Glide.with(this).load("http://image.tmdb.org/t/p/w185/${mMovie.poster_path}")
                .into(imageViewBackGround)


        detailsTitle.text = mMovie.title
        detailsReleaseDate.text = mMovie.releaseDate
        details_descr.text = mMovie.overview
    }

    companion object {
        const val TAG: String  = "detailFragment"
    }


}




