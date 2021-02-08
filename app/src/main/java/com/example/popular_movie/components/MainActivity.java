package com.example.popular_movie.components;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.popular_movie.R;

import com.example.popular_movie.database.PopularMovieModel;
import com.example.popular_movie.network.MovieDatabase;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // TODO: OVERRIDE FACTORY VIEWMODEL.FACTORY CREATE.
    private MoviesViewModel viewModel;

    private void initAndroidViewModel() {
        ViewModelFactory viewModelFactory = new ViewModelFactory(getApplicationContext());
        this.viewModel = new ViewModelProvider((ViewModelStoreOwner) getApplication(), viewModelFactory)
                .get(MoviesViewModel.class);

        //  TODO: make top rated movie DAO. SET IT UP IN VIEWMODEL WHEN I WAKE UP.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MovieDatabase.syncPopularMovies(getApplicationContext());
        initAndroidViewModel();

        setContentView(R.layout.activity_main);

        // set up recycler view layout manager
        RecyclerView moviePosterRecylerView = (RecyclerView) findViewById(R.id.rv_movie_poster);

        //popular movie list load as default.
        final MovieAdapter mAdapter = new MovieAdapter(this.viewModel.getPopularMoviesList());
        moviePosterRecylerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        moviePosterRecylerView.setLayoutManager(layoutManager);

        /*
         * Use this setting to improve performance if you know that changes in content do not
         * change the child layout size in the RecyclerView
         */
        moviePosterRecylerView.setHasFixedSize(true);


        /*
        This observer acts as a response to a database sync from the network.
         */
        this.viewModel.getPopularMoviesList().observe(MainActivity.this, new Observer<List<PopularMovieModel>>() {
            @Override
            public void onChanged(final List<PopularMovieModel> popularMovieModels) {
                mAdapter.notifyDataSetChanged();
            }
        });

    }
}