package com.example.popular_movie.network;

import android.content.Context;
import android.util.Log;
import com.example.popular_movie.R;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit movieAPIInstance = null;

    public static Retrofit getMovieAPIInstance(Context context) {
        Log.d("testt", "14");
        if(movieAPIInstance == null)
        {
            Log.d("testt", context.getResources().getString(R.string.base_url));
            movieAPIInstance = new retrofit2.Retrofit.Builder()
                    .baseUrl(context.getResources().getString(R.string.base_url))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        Log.d("testt", "24");
        return movieAPIInstance;
    }
}
