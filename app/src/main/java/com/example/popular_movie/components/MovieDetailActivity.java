package com.example.popular_movie.components;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.example.popular_movie.R;

public class MovieDetailActivity extends AppCompatActivity {
    private MovieDetailViewModel mViewModel;

    private void initAndroidViewModel(int dbId) {
        MovieDetailViewModelFactory movieDetailViewModelFactory = new MovieDetailViewModelFactory(getApplicationContext(), dbId);

        this.mViewModel = new ViewModelProvider(getViewModelStore(), movieDetailViewModelFactory).get(MovieDetailViewModel.class);

        //  TODO: make top rated movie DAO. SET IT UP IN VIEWMODEL WHEN I WAKE UP.
    }
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);
        int dbId = getIntent().getExtras().getInt(MainActivity.S_MOVIE_DATABASE_ID_KEY);

        initAndroidViewModel(dbId);
        /*
        android view model
        load from database and dota binding
         */
    }
}
