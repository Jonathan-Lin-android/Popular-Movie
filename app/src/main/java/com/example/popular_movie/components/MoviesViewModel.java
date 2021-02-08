package com.example.popular_movie.components;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.popular_movie.database.AppDatabase;
import com.example.popular_movie.database.PopularMovieDao;
import com.example.popular_movie.database.PopularMovieModel;
import java.util.List;

public class MoviesViewModel extends ViewModel {

    private final LiveData<List<PopularMovieModel>> popularMoviesList;

    private LiveData<List<PopularMovieModel>> topRatedMoviesList;

    public LiveData<List<PopularMovieModel>> getTopRatedMoviesList() {
        return topRatedMoviesList;
    }

    /*
        setting up list using LiveData Database auto update
    */
    MoviesViewModel(Context context) {
        PopularMovieDao popularMovieDao = AppDatabase.getInstance(context.getApplicationContext())
                .getPopularMovieDao();
        this.popularMoviesList = popularMovieDao.getAll();

    }

    public LiveData<List<PopularMovieModel>> getPopularMoviesList() {
        return popularMoviesList;
    }


}
