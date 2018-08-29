package com.example.khaledmahmoud.movieappusingmvp.ui.mainUi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.khaledmahmoud.movieappusingmvp.R
import com.example.khaledmahmoud.movieappusingmvp.di.component.DaggerMainActivityComponent
import com.example.khaledmahmoud.movieappusingmvp.di.module.MainActivityModule
import com.example.khaledmahmoud.movieappusingmvp.ui.ListMovieFragment.ListFragmentVeiw
import com.example.khaledmahmoud.movieappusingmvp.ui.detailMovieFragment.DetailFragmentView
import javax.inject.Inject

class MainActivityView : AppCompatActivity(), MainActivityMVPContract.MainActivityViewInterface {

    @Inject lateinit var presenter: MainActivityMVPContract.MainActivityPresenterInterface




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ingectDependency()


        presenter.attach(this)

    }



    override fun showlistFragment() {
        supportFragmentManager.beginTransaction().disallowAddToBackStack()
                .replace(R.id.container,ListFragmentVeiw(),"any").commit()
     }


    override fun showDetailsFragment() {

        if (supportFragmentManager.findFragmentByTag(DetailFragmentView.TAG) == null)
        {
            supportFragmentManager.beginTransaction()
                    .addToBackStack(null).replace(R.id.container,DetailFragmentView()
                            .newInstance(), DetailFragmentView.TAG).commit()

        }
        else{}
    }

    private fun ingectDependency()
    {
        val mainActivityComponent = DaggerMainActivityComponent.builder().
                mainActivityModule(MainActivityModule(this)).
                build()
        mainActivityComponent.inject(this)


    }


}