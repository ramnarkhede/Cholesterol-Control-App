package com.example.cholesterolcontrol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTestActivity extends AppCompatActivity {
    EditText date,general,hdl,ldl,triglycerides;
    Button btnSubmitTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test);

        date=findViewById(R.id.addDate);
        general=findViewById(R.id.addGeneral);
        hdl=findViewById(R.id.addHdl);
        ldl=findViewById(R.id.addLdl);
        triglycerides=findViewById(R.id.addTriglycerides);
        btnSubmitTest=findViewById(R.id.submitTest);


        btnSubmitTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "room_col").allowMainThreadQueries().build();
                UserDao userDao = db.userDao();
                if(date.getText().toString().isEmpty()||
                        general.getText().toString().isEmpty()||
                        hdl.getText().toString().isEmpty()||
                        ldl.getText().toString().isEmpty()||
                        triglycerides.getText().toString().isEmpty()){
                    Toast.makeText(AddTestActivity.this,"Please Enter Data in All Field...",Toast.LENGTH_LONG).show();
                }else{
                    userDao.insertTest(new Test(date.getText().toString(),
                            Integer.parseInt(general.getText().toString()),
                            Integer.parseInt(hdl.getText().toString()),
                            Integer.parseInt(ldl.getText().toString()),
                            Integer.parseInt(triglycerides.getText().toString())));

                    date.setText("");
                    general.setText("");
                    hdl.setText("");
                    ldl.setText("");
                    triglycerides.setText("");
                }

            }
        });
    }
}