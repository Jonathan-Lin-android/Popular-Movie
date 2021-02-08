package com.example.popular_movie.network;

import com.example.popular_movie.database.PopularMovieModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ApiMovieResponseModel {

    @SerializedName("results")
    List<PopularMovieModel> results;

    public List<PopularMovieModel> getResult() {
        return results;
    }

    public void setResult(final List<PopularMovieModel> results) {
        this.results = results;
    }

    public ApiMovieResponseModel(int id, List<PopularMovieModel> results) {
        this.results = results;
    }
}