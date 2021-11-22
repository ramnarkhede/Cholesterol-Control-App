package com.example.cholesterolcontrol;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao    //data access object
public interface UserDao {

    @Insert
    void insert(Day day);

    @Query("SELECT * FROM Day")
    List<Day> getAllDay();

    @Insert
    void insertTest(Test test);

    @Query("SELECT * FROM Test")
    List<Test> getAllTest();


}
