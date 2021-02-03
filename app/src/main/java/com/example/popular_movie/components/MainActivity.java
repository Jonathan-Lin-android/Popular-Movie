package com.example.popular_movie.components;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.popular_movie.R;
import com.example.popular_movie.network.NetworkUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView)findViewById(R.id.tv_test)).setText(NetworkUtil.urlMovieBuilder(getApplicationContext(), ("test")).toString());
    }
}