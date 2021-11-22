package com.example.cholesterolcontrol;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Day.class, Test.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
