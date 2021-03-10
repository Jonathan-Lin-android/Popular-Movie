package com.example.popular_movie.components;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.example.popular_movie.R;
import com.example.popular_movie.components.Fragment.FragmentService;
import com.example.popular_movie.components.Fragment.MovieDetailFragment;
import com.example.popular_movie.components.ViewModel.MoviesViewModel;
import com.example.popular_movie.components.ViewModel.MoviesViewModelFactory;
import com.example.popular_movie.config.TabConfig;
import com.example.popular_movie.network.MovieDatabase;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.Tab;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy;

public class MainActivity extends AppCompatActivity implements FragmentService.FragmentTransaction{

    private MoviesViewModel mViewModel;
    public final static String S_MOVIE_DATABASE_ID_KEY = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MovieDatabase.syncPopularMovies(getApplicationContext());
        this.mViewModel = initAndroidViewModel();

        setContentView(R.layout.activity_main);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager2 viewPager2 = findViewById(R.id.pager);

        TabConfig<Fragment> tabConfig = new TabConfig<Fragment>();

        viewPager2.setAdapter(new FragmentAdapter(getSupportFragmentManager(), this.getLifecycle(), tabConfig.getFragmentClassArray()));
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2,
                new TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull final Tab tab, final int position) {
                        tab.setText(tabConfig.getTabLabelArray()[position]);
                    }
                });
        tabLayoutMediator.attach();

    }

    private MoviesViewModel initAndroidViewModel() {
        MoviesViewModelFactory moviesViewModelFactory = new MoviesViewModelFactory(getApplicationContext());
        return new ViewModelProvider((ViewModelStoreOwner) getApplication(), moviesViewModelFactory)
                .get(MoviesViewModel.class);
        //  TODO: make top rated movie DAO. SET IT UP IN VIEWMODEL WHEN I WAKE UP.
    }

    @Override
    public void replace(final FragmentManager fm, final int containerId, final Fragment fragment, final String string) {
        FragmentTransaction transaction = fm.beginTransaction();

        //removes all attached fragments in the container.
        transaction.replace(containerId, fragment);
        //transaction.add(R.id.popular_movies_fragment_container, fragment, null);
        transaction.addToBackStack(null);
    }
}