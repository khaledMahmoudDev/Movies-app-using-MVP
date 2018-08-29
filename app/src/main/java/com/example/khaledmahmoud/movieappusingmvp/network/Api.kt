package com.example.khaledmahmoud.movieappusingmvp.network

import com.example.khaledmahmoud.movieappusingmvp.model.Movie
import com.example.khaledmahmoud.movieappusingmvp.model.MovieResult
import com.example.khaledmahmoud.movieappusingmvp.model.ReviewResult
import com.example.khaledmahmoud.movieappusingmvp.util.Constants
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api{

    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String): Observable<MovieResult>


    @GET("movie/{movie_id}/reviews")
    fun getReviews(@Path("movie_id") id: Int, @Query("api_key") apiKey: String ): Observable<ReviewResult>



    companion object {
        fun create(): Api {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constants.BASE_URL)
                    .build()

            return retrofit.create(Api::class.java)
        }
    }
}