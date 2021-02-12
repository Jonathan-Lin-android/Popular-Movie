package com.example.popular_movie.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface PopularMovieDao {

    @Query("SELECT * FROM movies")
    LiveData<List<MovieModel>> getAll();

    @Query("SELECT * FROM movies WHERE id = :movieId")
    LiveData<MovieModel> getMovie(int movieId);

    @Insert
    void insertAll(MovieModel... movieModels);

    @Insert
    void insertAll(List<MovieModel> movieModels);

    @Query("SELECT * FROM movies WHERE id IN (:movieIds)")
    LiveData<List<MovieModel>> loadAllByIds(int[] movieIds);

    @Query("DELETE FROM movies")
    void deleteAll();

/*
    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);
*/

    @Delete
    void delete(MovieModel movieModel);
}
