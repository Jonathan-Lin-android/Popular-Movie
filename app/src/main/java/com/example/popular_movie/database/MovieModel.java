package com.example.popular_movie.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "movies")
public class MovieModel {

    @PrimaryKey(autoGenerate = true)
    @Expose(serialize = false, deserialize = false)
    private int dbId;

    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int movieId;

    @ColumnInfo(name = "original_title")
    @SerializedName("original_title")
    private String originalTitle;

    @ColumnInfo(name = "original_language")
    @SerializedName("original_language")
    private String originalLanguage;

    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    private String posterPath; // (imageThumbnail)

    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    private String backdropPath; // (imageThumbnail)

    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    private String overview; //(sypnosis)

    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    private float voteAverage; //(user rating)

    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    private String releaseDate;

    @ColumnInfo(name = "popular_query")
    @Expose(serialize = false, deserialize = false)
    private boolean popularQuery;

    @ColumnInfo(name = "top_rated_query")
    @Expose(serialize = false, deserialize = false)
    private boolean topRatedQuery;

    @ColumnInfo(name = "favorite")
    @Expose(serialize = false, deserialize = false)
    private boolean favorite;

    @Ignore
    public MovieModel(int movieId, String originalTitle, String posterPath, String originalLanguage,
            String backdropPath, String overview, float voteAverage, String releaseDate,
            boolean popularQuery, boolean topRatedQuery, boolean favorite)
    {
        this.movieId = movieId;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.overview = overview;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
        this.popularQuery = popularQuery;
        this.topRatedQuery = topRatedQuery;
        this.favorite = favorite;
    }

    public MovieModel(int dbId, int movieId, String originalTitle, String originalLanguage,
            String posterPath, String backdropPath, String overview,
            float voteAverage, String releaseDate, boolean popularQuery, boolean topRatedQuery,
            boolean favorite) {
        this.dbId = dbId;
        this.movieId = movieId;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.overview = overview;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
        this.popularQuery = popularQuery;
        this.topRatedQuery = topRatedQuery;
        this.favorite = favorite;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(final String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(final int movieId) {
        this.movieId = movieId;
    }

    public int getDbId() {
        return dbId;
    }

    public void setDbId(final int dbId) {
        this.dbId = dbId;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(final String originalTitle) {
        this.originalTitle = originalTitle;
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

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(final String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(final String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public boolean isPopularQuery() {
        return popularQuery;
    }

    public void setPopularQuery(final boolean popularQuery) {
        this.popularQuery = popularQuery;
    }

    public boolean isTopRatedQuery() {
        return topRatedQuery;
    }

    public void setTopRatedQuery(final boolean topRatedQuery) {
        this.topRatedQuery = topRatedQuery;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(final boolean favorite) {
        this.favorite = favorite;
    }
}