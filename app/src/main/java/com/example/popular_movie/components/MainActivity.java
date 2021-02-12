package com.example.popular_movie.components;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.popular_movie.R;
import com.example.popular_movie.components.MovieAdapter.ListItemClickListener;
import com.example.popular_movie.database.MovieModel;
import com.example.popular_movie.network.MovieDatabase;
import java.util.List;

public class    MainActivity extends AppCompatActivity {

    private MoviesViewModel viewModel;
    public final static String S_MOVIE_DATABASE_ID_KEY = "1";

    private void initAndroidViewModel() {
        MoviesViewModelFactory moviesViewModelFactory = new MoviesViewModelFactory(getApplicationContext());
        this.viewModel = new ViewModelProvider((ViewModelStoreOwner) getApplication(), moviesViewModelFactory)
                .get(MoviesViewModel.class);
        //  TODO: make top rated movie DAO. SET IT UP IN VIEWMODEL WHEN I WAKE UP.
    }
    /*
textview ellpises
     tvDesc.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
         @Override
         public void onGlobalLayout() {
             tvDesc.getViewTreeObserver().removeOnGlobalLayoutListener(this);
             int noOfLinesVisible = tvDesc.getHeight() / tvDesc.getLineHeight();

             tvDesc.setText(getString(R.string.desc));

             tvDesc.setMaxLines(noOfLinesVisible);
             tvDesc.setEllipsize(TextUtils.TruncateAt.END);

         }
     });
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MovieDatabase.syncPopularMovies(getApplicationContext());
        initAndroidViewModel();

        setContentView(R.layout.activity_main);

        // set up recycler view layout manager
        RecyclerView moviePosterRecylerView = (RecyclerView) findViewById(R.id.rv_movie_poster);

        MovieAdapter.ListItemClickListener listItemClickListener = new ListItemClickListener() {
            @Override
            public void onItemClick(final int dbId) {
                Intent intent = new Intent(MainActivity.this, MovieDetailActivity.class);
                intent.putExtra(MainActivity.S_MOVIE_DATABASE_ID_KEY, dbId);
                startActivity(intent);
            }
        };

        //popular movie list load as default.
        final MovieAdapter mAdapter = new MovieAdapter(this.viewModel.getPopularMoviesList(), listItemClickListener);
        moviePosterRecylerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        moviePosterRecylerView.setLayoutManager(layoutManager);

        moviePosterRecylerView.setHasFixedSize(true);

        /*
        This observer acts as a response to a database sync from the network.
         */
        this.viewModel.getPopularMoviesList().observe(MainActivity.this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(final List<MovieModel> movieModels) {
                mAdapter.notifyDataSetChanged();
            }
        });

    }

}