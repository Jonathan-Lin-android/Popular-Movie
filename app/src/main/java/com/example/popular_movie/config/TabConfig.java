package com.example.popular_movie.config;

import androidx.fragment.app.Fragment;
import com.example.popular_movie.components.Fragment.PopularMovieFragment;

public class TabConfig <T extends Fragment> {
    private final Class<T> [] fragmentClassArray = new Class [] {
            PopularMovieFragment.class
    };

    private final String tabLabelArray [] = new String[] {
            "Popular Movie"
    };

    public Class<T>[] getFragmentClassArray() {
        return fragmentClassArray;
    }

    public String[] getTabLabelArray() {
        return tabLabelArray;
    }
}
