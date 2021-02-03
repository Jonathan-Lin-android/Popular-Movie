package com.example.popular_movie.network;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Network;
import android.net.Uri;
import com.example.popular_movie.R;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtil {

/*
connecting the web. (opening a sesesion with API and get response) returns a String
 */

    /*
        @param String - valid paths: top_rated or popular
        @return - URL and null if input is an invalid path.
     */
    public static URL urlMovieBuilder(Context context, String path) {
        Resources res = context.getResources();

        Uri.Builder buildUri = new Uri.Builder();
        buildUri.scheme(res.getString(R.string.scheme));
        buildUri.path(res.getString(R.string.base_url));
        buildUri.appendPath(res.getString(R.string.type));
        buildUri.appendPath(path);
//        buildUri.appendQueryParameter(res.getString(R.string.query_api_key), res.getString(R.string.query_api_value));
        buildUri.appendQueryParameter(res.getString(R.string.query_api_key), getAPIValue(res));

        Uri uri = buildUri.build();
        try {
            return new URL(uri.toString());
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private static String getAPIValue(Resources res)
    {
        return res.getString(R.string.query_api_value);
    }
}
