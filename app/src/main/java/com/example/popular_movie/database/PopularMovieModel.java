package com.example.popular_movie.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "popular_movies")
public class PopularMovieModel {
    @PrimaryKey(autoGenerate = true)
    @Expose(serialize = false, deserialize = false)
    private int dbId;

    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;

    @ColumnInfo(name = "original_title")
    @SerializedName("original_title")
    private String originalTitle;

    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    private String moviePosterImageThumbnail; // (imageThumbnail)

    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    private String overview; //(sypnosis)

    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    private float voteAverage; //(user rating)

    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    private String releaseDate;

    @Ignore
    public PopularMovieModel(int id, String originalTitle, String moviePosterImageThumbnail, String overview,
            float voteAverage, String releaseDate) {
        this.id = id;
        this.originalTitle = originalTitle;
        this.moviePosterImageThumbnail = moviePosterImageThumbnail;
        this.overview = overview;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
    }

    public PopularMovieModel(int dbId, int id, String originalTitle, String moviePosterImageThumbnail, String overview,
            float voteAverage, String releaseDate) {
        this.dbId = dbId;
        this.id = id;
        this.originalTitle = originalTitle;
        this.moviePosterImageThumbnail = moviePosterImageThumbnail;
        this.overview = overview;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
    }


    public int getDbId() {
        return dbId;
    }

    public void setDbId(final int dbId) {
        this.dbId = dbId;
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