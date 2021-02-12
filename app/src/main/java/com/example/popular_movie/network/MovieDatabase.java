package com.example.popular_movie.network;

import android.content.Context;
import android.util.Log;
import com.example.popular_movie.database.AppDatabase;
import com.example.popular_movie.database.PopularMovieDao;
import com.example.popular_movie.database.MovieModel;
import com.example.popular_movie.threads.AppExecutors;
import java.io.IOException;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDatabase {
//    public static void syncTopRatedMoviesDatabase(Context context) {}

    public static void syncPopularMovies(Context context) {
        ApiMovieService service = RetrofitClient.getMovieAPIInstance(context.getApplicationContext())
                .create(ApiMovieService.class);

        //gets api key from raw file
        Call<ApiMovieResponseModel> call = service.getPopularMovies(NetworkUtil.getAPIValue(context.getResources()));

        //call is executed asynchronously
        call.enqueue(new Callback<ApiMovieResponseModel>() {

            // All retrofits callback are queued on the main thread.
            @Override
            public void onResponse(final Call<ApiMovieResponseModel> call,
                    final Response<ApiMovieResponseModel> response) {
                Log.d("testt", "success: " + String.valueOf(response.isSuccessful()));
                Log.d("testt", "code: " + response.code());

                Log.d("testt", "status message: " + response.message());
                Log.d("testt", "Response errorBody" + response.raw().request().url());

                if (!response.isSuccessful()) {
                    return;
                }

                // create background thread.
                AppExecutors.getInstance().diskIO().execute(
                        new Runnable() {
                            @Override
                            public void run() {
                                //request is successful
                                ApiMovieResponseModel apiModel = response.body();

                                List<MovieModel> movieList = apiModel.getResult();
                                //check if it loads correctly
                                for(MovieModel m : movieList)
                                {
                                    Log.d("testt", "movie: " + m.getOriginalTitle());
                                    Log.d("testt", "movie: " + m.toString());

                                }

                                //Database operations
                                AppDatabase db = AppDatabase.getInstance(null);
                                if (db != null) {
                                    PopularMovieDao dao = db.getPopularMovieDao();

                                    // resync database
                                    dao.deleteAll();
                                    MovieModel[] arr = new MovieModel[movieList.size()];
                                    dao.insertAll(movieList.toArray(arr));
                                }
                            }
                        });

            }

            @Override
            public void onFailure(final Call<ApiMovieResponseModel> call, final Throwable t) {
                if (t instanceof IOException) {
                    Log.d(this.getClass().getSimpleName(), "unsuccessful request");
                } else {
                    Log.d(this.getClass().getSimpleName(), "model conversion issue");
                }
            }
        });
    }
}