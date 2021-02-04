package com.example.popular_movie.components;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.popular_movie.R;
import com.example.popular_movie.network.APIMovieService;
import com.example.popular_movie.network.MovieModel;
import com.example.popular_movie.network.NetworkUtil;
import com.example.popular_movie.network.RetrofitClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView testTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testTextView = findViewById(R.id.tv_test);
        testTextView.setText(NetworkUtil.urlMovieBuilder(getApplicationContext(), ("test")).toString());

        APIMovieService service = RetrofitClient.getMovieAPIInstance(getApplicationContext()).create(APIMovieService.class);
        //gets api key from raw file
        Call<List<MovieModel>> call = service.getPopularMovies(NetworkUtil.getAPIValue(getResources()));

        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(final Call<List<MovieModel>> call, final Response<List<MovieModel>> response) {
                MainActivity.this.testTextView.setText("");
                List<MovieModel> list = response.body();
                if (list == null)
                    Log.d("testt", "null");
/*
                for (int i = 0; i < list.size(); i++) {
                    Log.d("testt", "index: " + i + list.get(i).getOriginalTitle());
                }
  */
                        /*
                        for(MovieModel m : list) {
                            ((TextView) findViewById(R.id.tv_test)).append(m.getOriginalTitle() +"\n");
                        }
                        ((TextView) findViewById(R.id.tv_test)).append(list.toString() +"\n");
                         */
            }

            @Override
            public void onFailure(final Call<List<MovieModel>> call, final Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}