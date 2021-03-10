package com.example.popular_movie.database;

import androidx.lifecycle.LiveData;
import androidx.room.Query;
import java.util.List;

public interface MovieDao {
    LiveData<List<MovieModel>> getAll();
}
