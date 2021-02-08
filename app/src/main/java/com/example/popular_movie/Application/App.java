package com.example.popular_movie.Application;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

public class App extends Application implements ViewModelStoreOwner {
    private final ViewModelStore mViewModelStore = new ViewModelStore();

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return mViewModelStore;
    }
}
