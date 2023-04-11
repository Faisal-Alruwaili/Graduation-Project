package com.example.graduation_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button TrackAttendanceBtn;
    private Button TrackLateAttendanceBtn;
    private Button ManageStudentBtn;
    //private Button ... ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Track Attendance Button in Main Activity
        TrackAttendanceBtn = (Button) findViewById(R.id.TrackAttendanceBtn);

        TrackAttendanceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenTrackAttendanceActivity();
            }
        });


        //Track Late Student Button in Main Activity

        TrackLateAttendanceBtn = (Button) findViewById(R.id.TrackLateAttendanceBtn);

        TrackLateAttendanceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenTrackLateAttendanceActivity();
            }
        });


        //Manage Student Button in Main Activity

        ManageStudentBtn = (Button) findViewById(R.id.ManageStudentBtn);

        ManageStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenManageStudentActivity();
            }
        });
    }

    // Open Track Attendance Activity method for TrackAttendanceBtn
    public void OpenTrackAttendanceActivity() {
        Intent intent = new Intent(this, TrackAttendanceActivity.class);
        startActivity(intent);

    }

    //Open Track Late Student Activity method for TrackLateStudentBtn
    public void OpenTrackLateAttendanceActivity() {
        Intent intent = new Intent(this, TrackLateAttendanceActivity.class);
        startActivity(intent);
    }

    //Open Manage Student Activity method for ManageStudentBtn
    public void OpenManageStudentActivity() {
        Intent intent = new Intent(this, ManageStudentActivity.class);
        startActivity(intent);
    }



        }

