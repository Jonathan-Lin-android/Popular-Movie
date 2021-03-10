package com.example.popular_movie.components.ViewModel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.popular_movie.database.AppDatabase;
import com.example.popular_movie.database.PopularMovieDao;
import com.example.popular_movie.database.MovieModel;
import java.util.List;

//TODO: create filter function for movies to filter by favorite, top movies, and popular. Transformations? or Stream?
public class MoviesViewModel extends ViewModel {

    private final LiveData<List<MovieModel>> popularMoviesList;

    private LiveData<List<MovieModel>> topRatedMoviesList;

    /*
        setting up list using LiveData Database auto update
    */
    MoviesViewModel(Context context) {
        PopularMovieDao popularMovieDao = AppDatabase.getInstance(context.getApplicationContext())
                .getPopularMovieDao();
        this.popularMoviesList = popularMovieDao.getAll();

    }

    public LiveData<List<MovieModel>> getTopRatedMoviesList() {
        return topRatedMoviesList;
    }
    public LiveData<List<MovieModel>> getPopularMoviesList() {
        return popularMoviesList;
    }
}
