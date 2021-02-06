package com.example.popular_movie.components;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.popular_movie.R;
import com.example.popular_movie.network.ApiMovieResponseModel.MovieModel;
import com.example.popular_movie.network.ApiMovieService;
import com.example.popular_movie.network.ApiMovieResponseModel;
import com.example.popular_movie.network.NetworkUtil;
import com.example.popular_movie.network.RetrofitClient;
import java.util.List;
import retrofit2.Response;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ApiMovieService service = RetrofitClient.getMovieAPIInstance(getApplicationContext()).create(ApiMovieService.class);

        //gets api key from raw file
        Call<ApiMovieResponseModel> call = service.getPopularMovies(NetworkUtil.getAPIValue(getResources()));

        // implement and define the call back in a different class.
        call.enqueue(new Callback<ApiMovieResponseModel>() {

            /*
            create Callback class
            this method only insert into database
            in Activity onCreate()
            {
            setup ViewModel with database.loadAll() even if database is empty. because of live data it will update as we insert into database.
            }
             */
            /*
            TODO: sleep the thread for 5 seconds, navigate to new activity, see if viewmodel of MainActivity is still updated.
            TODO: if activity is destroyed does it still try to update the main activity view model.
            insert movie models into database.
            setup android view model.
            view model.movieList = DAO.loadAllMovies();
             */
            @Override
            public void onResponse(final Call<ApiMovieResponseModel> call, final Response<ApiMovieResponseModel> response) {
                Log.d("testt","success: " + 	String.valueOf(response.isSuccessful()));
                Log.d("testt","code: " + response.code());

                Log.d("testt","status message: " + response.message());
                Log.d("testt", "Response errorBody" + response.raw().request().url());

                if(!response.isSuccessful())
                    return;

                assert response.body() != null;

                ApiMovieResponseModel apiModel = response.body();
                List<MovieModel> movieList = apiModel.getResult();

                if(movieList == null) {
                    Log.d("testt", "result is null");
                 //   throw new RuntimeException("movieList is null");
                }

                for(MovieModel m : movieList) {

                            ((TextView) findViewById(R.id.tv_test)).append(m.getOriginalTitle() +"\n");
                        }
                        ((TextView) findViewById(R.id.tv_test)).append(movieList.toString() +"\n");


            }
            @Override
            public void onFailure(final Call<ApiMovieResponseModel> call, final Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}