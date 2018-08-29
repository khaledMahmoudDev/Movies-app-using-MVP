package com.example.khaledmahmoud.movieappusingmvp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Movie(var title: String? = null,
            var id: Int = 0,
            var overview: String? = null,
            @SerializedName("release_date") var releaseDate: String? = null,
            var poster_path:String? = null,
            var reviews: ReviewResult):Serializable {

}