package com.example.popular_movie.components;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MoviesViewModelFactory implements ViewModelProvider.Factory {

    private final Context context;

    public MoviesViewModelFactory(Context context)
    {
        this.context = context.getApplicationContext();
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull final Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MoviesViewModel.class)) {
            return ((T) new MoviesViewModel(this.context));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
