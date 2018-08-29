package com.example.khaledmahmoud.movieappusingmvp.ui.ListMovieFragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.ListFragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.khaledmahmoud.movieappusingmvp.R
import com.example.khaledmahmoud.movieappusingmvp.di.component.DaggerFragmentComponent
import com.example.khaledmahmoud.movieappusingmvp.di.module.FragmentModule
import com.example.khaledmahmoud.movieappusingmvp.model.Movie
import com.example.khaledmahmoud.movieappusingmvp.ui.detailMovieFragment.DetailFragmentView
import kotlinx.android.synthetic.main.activity_list.*
import javax.inject.Inject

class ListFragmentVeiw: ListFragmentMVPContract.ListFragmentViewInterface,ListAdapter.onItemClickListener, Fragment() {


    override fun itemDetail(movie: Movie) {

        val bundle = Bundle()
        bundle.putSerializable("movie", movie)


        val detailFragmentView = DetailFragmentView()
        detailFragmentView.arguments = bundle

        val fragmentManger = (context as AppCompatActivity).supportFragmentManager


        fragmentManger.beginTransaction().replace(R.id.container, detailFragmentView)
                .addToBackStack(null).commit()

    }

    @Inject lateinit var presenter: ListFragmentMVPContract.ListFragmentPresenterInterfce
    private lateinit var rootView : View

    fun newInstance():ListFragment {
        return ListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependecy()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.rootView = inflater.inflate(R.layout.activity_list, container,false)
        return this.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.subscribe()
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }

    companion object {
        val TAG: String = "ListFragmenet"
    }
    private fun initView(){
        presenter.loadData()
    }

    private fun injectDependecy(){
            val listComponent = DaggerFragmentComponent.builder().fragmentModule(FragmentModule()).build()
        listComponent.inject(this)
    }

    override fun showProgress(show: Boolean) {
        if (show){
            progressBar.visibility = View.VISIBLE
        }else
            progressBar.visibility = View.GONE

    }

    override fun showErrorMessage(error: String) {
        Toast.makeText(context, "error$error",Toast.LENGTH_LONG).show()


    }

    override fun loadDataSuccess(list: List<Movie>) {
        var adapter = ListAdapter(context, this,list)
        recyclerView!!.layoutManager = GridLayoutManager(activity,2)
        recyclerView.adapter = adapter




    }
}