package com.example.popular_movie.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface PopularMovieDao {

    @Query("SELECT * FROM popular_movies")
    LiveData<List<PopularMovieModel>> getAll();

    @Insert
    void insertAll(PopularMovieModel ... movieModels);

    @Insert
    void insertAll(List<PopularMovieModel> movieModels);

    @Query("SELECT * FROM popular_movies WHERE id IN (:movieIds)")
    LiveData<List<PopularMovieModel>> loadAllByIds(int[] movieIds);

    @Query("DELETE FROM popular_movies")
    void deleteAll();

/*
    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);
*/

    @Delete
    void delete(PopularMovieModel movieModel);
}
