package com.example.aashishkumar.rootcause01;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Calendar;

public class TrackTrip extends AppCompatActivity {

    public EditText start;
    public EditText end;
    public TextView text;
    public String mode;
    public ImageButton imageButton;
    public boolean selectedAnother;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_trip);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        start = (EditText) findViewById(R.id.starttextbox);
        end = (EditText) findViewById(R.id.endtextbox);
        text = (TextView) findViewById(R.id.displaytext);
        text.setText("Here");
        //Create file data here.
    }

    public void Submit(View view) throws IOException {
        start = (EditText) findViewById(R.id.starttextbox);
        end = (EditText) findViewById(R.id.endtextbox);
        text = (TextView) findViewById(R.id.displaytext);

        if(start.getText().length() == 0 || end.getText().length() == 0 || mode.length() == 0)
        {
            text.setText("Please input all the parameters to submit");
            text.setTextColor(Color.RED);
            return;
        }



        text.setTextColor(Color.CYAN);
        String complete = "";
        complete += start.getText(); complete += "*" + mode + "*"; complete += end.getText() + "*"; complete += Calendar.getInstance().getTime().toString().substring(0, 10); complete += "λ";
        try {
            FileOutputStream stream = new FileOutputStream(MainActivity.tripsfile, true);
            try{
                stream.write(complete.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String contents = "";
        Scanner in = new Scanner(MainActivity.tripsfile);
        while (in.hasNextLine())
        {
            contents += in.nextLine();
        }

        text.setText(contents);
        start.setText(""); end.setText(""); mode = "";
    }

    public void SelectTrain(View view)
    {
        if (mode != "Train") {
            mode = " Train ";
            imageButton = findViewById(R.id.train);
            imageButton.setBackgroundResource(R.drawable.ic_train_clicked);
        }

    }

    public void SelectBus(View view)
    {
        if (mode != "Bus") {
            mode = " Bus ";
            imageButton = findViewById(R.id.bus);
            imageButton.setBackgroundResource(R.drawable.ic_bus_clicked);
        }
    }

    public void SelectCar(View view)
    {
        if (mode != " Car ") {
            mode = " Car ";
            imageButton = findViewById(R.id.ecar);
            imageButton.setBackgroundResource(R.drawable.ic_car_clicked);
        }
    }


}
