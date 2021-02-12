package com.example.popular_movie.database;

import androidx.room.TypeConverter;

public class Converters {
    @TypeConverter
    public static boolean fromBoolean(int value) {
        return value == 1;
    }

    @TypeConverter
    public static Integer integerToBoolean(boolean b)
    {
        return b ? Integer.valueOf(1) : Integer.valueOf(0);
    }
}