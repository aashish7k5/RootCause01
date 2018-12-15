package com.example.aashishkumar.rootcause01;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ViewPastTrips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_past_trips);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TextView mtext = findViewById(R.id.text);

        TextView tstart = findViewById(R.id.info_text1);
        TextView tend = findViewById(R.id.info_text2);
        TextView tmode = findViewById(R.id.info_text1);
        TextView tdate = findViewById(R.id.info_text2);

        String contents = "";
        Scanner in = null;
        try {
            in = new Scanner(MainActivity.tripsfile);
            while (in.hasNextLine())
            {
                contents += in.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(contents.equals(""))
        {
            contents = "You don't have any trips yet!";
        }

        //        complete += start.getText(); complete += " *" + mode + "* "; complete += end.getText() + "//"; complete += Calendar.getInstance().getTime().toString().substring(0, 10); complete += "λ";
        String[] trips = contents.split("λ");
        String[] start = new String[trips.length];
        String[] end = new String[trips.length];
        String[] mode = new String[trips.length];
        String[] date = new String[trips.length];
        String splitcontents = "";


        //The arrays start, end, mode and date are what you can use in Google cards. Something like looping through the length of any of them, creating a google card for each i, and then
        //adding the same index values to each card.
        for(int i = 0; i<trips.length; i++)
        {
            trips[i] = trips[i].replaceAll("\\*", "*");
            String[] split = trips[i].split("\\*");
            start[i] = split[0]; mode[i] = split[1]; end[i] = split[2]; date[i] = split[3];
            splitcontents += "Start = " + start[i] + " End = " + end[i] + " Mode = " + mode[i] + " Date = " + date[i];
            splitcontents += "\n";
            splitcontents += "\n";

        }
        //mtext.setText(splitcontents);
        tstart.setText(start[start.length-1]);
        tend.setText(end[end.length-1]);
        tmode.setText(mode[mode.length-1]);
        tdate.setText(date[date.length-1]);
    }

}
