package com.example.popular_movie.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.popular_movie.R;

@Database(entities = {PopularMovieModel.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance = null;

    public static AppDatabase getInstance(Context context)
    {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, context.getString(R.string.database_name))
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract PopularMovieDao getPopularMovieDao();

}
