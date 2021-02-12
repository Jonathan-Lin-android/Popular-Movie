package com.example.popular_movie.components;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MovieDetailViewModelFactory implements ViewModelProvider.Factory {

    private final Context context;

    private final int dbId;

    public MovieDetailViewModelFactory(Context context, int dbId) {
        this.context = context.getApplicationContext();
        this.dbId = dbId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull final Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieDetailViewModel.class)) {
            return ((T) new MovieDetailViewModel(this.context, this.dbId));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
