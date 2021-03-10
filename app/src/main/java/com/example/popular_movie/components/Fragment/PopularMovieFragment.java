package com.example.popular_movie.components.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.popular_movie.R;
import com.example.popular_movie.components.Fragment.MovieAdapter.ListItemClickListener;
import com.example.popular_movie.components.ViewModel.MoviesViewModel;
import com.example.popular_movie.components.ViewModel.MoviesViewModelFactory;
import com.example.popular_movie.database.MovieModel;
import java.util.List;

public class PopularMovieFragment extends Fragment
{

    public final static String S_MOVIE_DATABASE_ID_KEY = "1";

    MoviesViewModel mViewModel;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mViewModel = initAndroidViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.popular_movies_fragment, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View root, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(root, savedInstanceState);

        // set up recycler view layout manager
        RecyclerView moviePosterRecylerView = (RecyclerView) root.findViewById(R.id.rv_movie_poster);
        MovieAdapter.ListItemClickListener listItemClickListener = new ListItemClickListener() {
            @Override
            public void onItemClick(final int movieDbId) {
                Bundle bundle = new Bundle();
                bundle.putInt(PopularMovieFragment.S_MOVIE_DATABASE_ID_KEY, movieDbId);

                Fragment fragment = new MovieDetailFragment();
                fragment.setArguments(bundle);

                FragmentManager fm = getParentFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();

                // removes all attached fragments in the container.
                transaction.replace(R.id.popular_movies_fragment_container, fragment, null);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        };

        // popular movie list load as default.
        final MovieAdapter mAdapter = new MovieAdapter(this.mViewModel.getPopularMoviesList(), listItemClickListener);

        moviePosterRecylerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        moviePosterRecylerView.setLayoutManager(layoutManager);

        moviePosterRecylerView.setHasFixedSize(true);

        /*
        This observer acts as a response to a database sync from the network.
         */
        this.mViewModel.getPopularMoviesList().observe((LifecycleOwner) this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(final List<MovieModel> movieModels) {
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    private MoviesViewModel initAndroidViewModel() {
        MoviesViewModelFactory moviesViewModelFactory = new MoviesViewModelFactory(
                getActivity().getApplicationContext());
        return new ViewModelProvider((ViewModelStoreOwner) getActivity().getApplicationContext(),
                moviesViewModelFactory)
                .get(MoviesViewModel.class);
        //  TODO: make top rated movie DAO. SET IT UP IN VIEWMODEL WHEN I WAKE UP.
    }
}