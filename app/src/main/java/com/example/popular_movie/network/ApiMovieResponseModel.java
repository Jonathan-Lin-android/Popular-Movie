package com.example.popular_movie.network;

import com.example.popular_movie.database.MovieModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ApiMovieResponseModel {

    @SerializedName("results")
    List<MovieModel> results;

    public List<MovieModel> getResult() {
        return results;
    }

    public void setResult(final List<MovieModel> results) {
        this.results = results;
    }

    public ApiMovieResponseModel(int id, List<MovieModel> results) {
        this.results = results;
    }
}