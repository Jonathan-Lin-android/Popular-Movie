package com.example.popular_movie.network;

import androidx.annotation.NonNull;
import com.google.gson.annotations.Expose;
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


    public static class MovieModel {

        @SerializedName("id")
        int id;

        @SerializedName("original_title")
        String originalTitle;

        @SerializedName("poster_path")
        String moviePosterImageThumbnail; // (imageThumbnail)

        @SerializedName("overview")
        String overview; //(sypnosis)

        @SerializedName("vote_average")
        float voteAverage; //(user rating)

        @SerializedName("release_date")
        String releaseDate;

        public MovieModel(int id, String originalTitle, String moviePosterImageThumbnail, String overview,
                float voteAverage, String releaseDate) {
            this.id = id;
            this.originalTitle = originalTitle;
            this.moviePosterImageThumbnail = moviePosterImageThumbnail;
            this.overview = overview;
            this.voteAverage = voteAverage;
            this.releaseDate = releaseDate;
        }

        public int getId() {
            return id;
        }

        public void setId(final int id) {
            this.id = id;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public void setOriginalTitle(final String originalTitle) {
            this.originalTitle = originalTitle;
        }

        public String getMoviePosterImageThumbnail() {
            return moviePosterImageThumbnail;
        }

        public void setMoviePosterImageThumbnail(final String moviePosterImageThumbnail) {
            this.moviePosterImageThumbnail = moviePosterImageThumbnail;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(final String overview) {
            this.overview = overview;
        }

        public float getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(final float voteAverage) {
            this.voteAverage = voteAverage;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(final String releaseDate) {
            this.releaseDate = releaseDate;
        }
    }
}