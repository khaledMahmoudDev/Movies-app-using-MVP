package com.example.khaledmahmoud.movieappusingmvp.ui.ListMovieFragment

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.khaledmahmoud.movieappusingmvp.R
import com.example.khaledmahmoud.movieappusingmvp.model.Movie
import kotlinx.android.synthetic.main.activity_row_element.view.*

class ListAdapter (private val context: Context?,fragment:Fragment, private val list: List<Movie>) : RecyclerView.Adapter<ListHolder>() {
;
    private val listener : com.example.khaledmahmoud.movieappusingmvp.ui.ListMovieFragment.ListAdapter.onItemClickListener
    init {
        this.listener = fragment as onItemClickListener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.activity_row_element, parent,false)
        return ListHolder(itemView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ListHolder, position: Int) {

        var mMovie = list[position]

        Glide.with(this.context!!).
                load("http://image.tmdb.org/t/p/w185/"+ mMovie.poster_path).
                into(holder.movieImag)

        holder.layout.setOnClickListener {
            listener.itemDetail(mMovie)

        }
    }

    interface onItemClickListener {
        fun itemDetail(movie: Movie)
    }
}
class ListHolder (itemView: View): RecyclerView.ViewHolder(itemView){

    var layout = itemView.itemLayout
    var movieImag = itemView.imageId



}