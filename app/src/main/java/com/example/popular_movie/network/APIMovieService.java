package com.example.popular_movie.network;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIMovieService {

    @GET("/movie/popular")
    Call<List<MovieModel>> getPopularMovies(@Query("api_key") String api_key);

    @GET("/movie/top_rated")
    Call<List<MovieModel>> getTopRatedMovies();
}