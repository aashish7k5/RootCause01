package com.example.aashishkumar.rootcause01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.io.File;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static File tripsfile;
    private TextView mTextMessage;
    public static File settings;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tripsfile = new File(getApplicationContext().getFilesDir(), "tripsdata");

        settings = new File(getApplicationContext().getFilesDir(), "settings");
    }


    public void TrackTripScreen(View view)
    {
        //This method works.
        Intent intent = new Intent(this, TrackTrip.class);
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void ViewPastTripsScreen(View view)
    {
        Intent intent = new Intent(this, ViewPastTrips.class);
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void SettingsScreen(View view)
    {
        Intent intent = new Intent(this, SettingsNew.class);
        startActivity(intent);
    }
}
