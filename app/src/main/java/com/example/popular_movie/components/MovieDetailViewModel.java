package com.example.popular_movie.components;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.popular_movie.database.AppDatabase;
import com.example.popular_movie.database.MovieModel;

/*
boolean top_Rated movie column true
false for popular movie.
for table reuse.

/*

For Top_rated Movies dao?
@transaction

model = getMovieID to see if it exist
if movie does not exist (getter returns -1 id?????? not sure default behavior)
    insert(model)

else
{
model.setTopRated = true;
}
*/
public class MovieDetailViewModel extends ViewModel {

    private final LiveData<MovieModel> movieModel;
    MovieDetailViewModel(Context context, int dbId)
    {
        movieModel = AppDatabase.getInstance(context.getApplicationContext()).getPopularMovieDao().getMovie(dbId);
    }

    public LiveData<MovieModel> getMovieModel() {
        return movieModel;
    }
}
