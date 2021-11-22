package com.example.cholesterolcontrol;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;



    @Entity
    public class Day {
        @PrimaryKey(autoGenerate = true)
        public int uid;

        @ColumnInfo(name = "day_count")
        public int dayCount;

        @ColumnInfo(name = "date")
        public String date;



        public Day(int dayCount,String date) {

            this.dayCount = dayCount;
            this.date=date;

        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getDayCount() {
            return dayCount;
        }

        public void setDayCount(int dayCount) {
            this.dayCount = dayCount;
        }


        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
