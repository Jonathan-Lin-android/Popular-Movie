package com.example.popular_movie.components.Fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

//TODO: used in TopRatedMovieFragment
public class FragmentService {
    /*
    @param int - Container
    @param Fragment - fragment to be replaced with
    @param String - optional id
     */
    public interface FragmentTransaction {
        public void replace(final FragmentManager fm, int containerId, Fragment fragment, String string);
    }
}
