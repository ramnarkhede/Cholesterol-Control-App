package com.example.cholesterolcontrol;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


    @Entity
    public class Test {
        @PrimaryKey(autoGenerate = true)
        public int uid;
        @ColumnInfo(name = "date")
        public String dateTest;
        @ColumnInfo(name = "general")
        public int general;

        @ColumnInfo(name = "hdl")
        public int hdl;

        @ColumnInfo(name = "ldl")
        public int ldl;

        @ColumnInfo(name = "triglycerides")
        public int triglycerides;

        public Test(String dateTest,int general, int hdl, int ldl, int triglycerides) {
            this.dateTest=dateTest;
            this.general = general;
            this.hdl = hdl;
            this.ldl = ldl;
            this.triglycerides = triglycerides;

        }

        public String getDateTest() {
            return dateTest;
        }

        public void setDateTest(String dateTest) {
            this.dateTest = dateTest;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getGeneral() {
            return general;
        }

        public void setGeneral(int general) {
            this.general = general;
        }

        public int getHdl() {
            return hdl;
        }

        public void setHdl(int hdl) {
            this.hdl = hdl;
        }

        public int getLdl() {
            return ldl;
        }

        public void setLdl(int ldl) {
            this.ldl = ldl;
        }

        public int getTriglycerides() {
            return triglycerides;
        }

        public void setTriglycerides(int triglycerides) {
            this.triglycerides = triglycerides;
        }
    }
