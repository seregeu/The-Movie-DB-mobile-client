package com.example.summer_school_hw.model.retrofit.Interface

import com.example.summer_school_hw.model.retrofit.Models_retrofit.MovieInListResult
import com.example.summer_school_hw.model.retrofit.Models_retrofit.MovieCredits
import com.example.summer_school_hw.model.retrofit.Models_retrofit.ReleaseAnswer
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("movie/{id}/release_dates")
    suspend fun getMovieReleaseData(@Path("id") movieId:Int,@Query("api_key") apiKey: String,@Query("language") lang:String): Response<ReleaseAnswer>

    @GET("movie/popular")
    suspend fun getPopularMoviesList(@Query("api_key") apiKey: String,@Query("language") lang:String): Response<MovieInListResult>

    @GET("movie/{id}/credits")
    suspend fun getMovieCreditsById(@Path("id") movieId:Int,@Query("api_key") apiKey: String,@Query("language") lang:String):Response<MovieCredits>
}