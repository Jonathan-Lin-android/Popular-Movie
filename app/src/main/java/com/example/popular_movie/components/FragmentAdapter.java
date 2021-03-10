package com.example.popular_movie.components;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {
    Class<Fragment> [] mFragmentArray;

    public FragmentAdapter(FragmentManager fm, Lifecycle lifecycle, Class<Fragment> [] fragmentArray ) {
        super(fm, lifecycle);
        this.mFragmentArray = fragmentArray;
    }

    @Override
    public Fragment createFragment(final int position) {
        try {
            return mFragmentArray[position].newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return mFragmentArray.length;
    }
}