package com.example.popular_movie.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiMovieService {
    @GET("movie/popular")
    Call<ApiMovieResponseModel> getPopularMovies(@Query("api_key") String api_key);

    @GET("movie/top_rated")
    Call<ApiMovieResponseModel> getTopRatedMovies(@Query("api_key") String api_key);
}