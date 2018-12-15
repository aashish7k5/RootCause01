package com.example.aashishkumar.rootcause01;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
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
import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ViewPastTrips extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Model> imageModelArrayList;
    private Adapter adapter;

    private int[] myImageList = new int[10];
    private String[] myImageNameList = new String[10];

    String[] trips;
    String[] start;
    String[] end;
    String[] mode;
    String[] date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_past_trips);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("View Past Trips");

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        imageModelArrayList = populateList();
        adapter = new Adapter(this, imageModelArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {

            @Override
            public void onClick(View view, int position) {
                Toast.makeText(ViewPastTrips.this, imageModelArrayList.get(position).getText1(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));




    }


    private ArrayList<Model> populateList(){
//TextView mtext = findViewById(R.id.text);

        TextView tstart = findViewById(R.id.info_text1);
        TextView tend = findViewById(R.id.info_text2);
        TextView tmode = findViewById(R.id.info_text1);
        TextView tdate = findViewById(R.id.info_text2);
        TextView tsaved = findViewById(R.id.info_text1);

        String contents = "";
        Scanner in = null;
        try {
            in = new Scanner(MainActivity.tripsfile);
            while (in.hasNextLine()) {
                contents += in.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (contents.equals("")) {
            contents = "You don't have any trips yet!";
        }

        //        complete += start.getText(); complete += " *" + mode + "* "; complete += end.getText() + "//"; complete += Calendar.getInstance().getTime().toString().substring(0, 10); complete += "λ";


            trips = contents.split("λ");
            start = new String[trips.length];
            end = new String[trips.length];
            mode = new String[trips.length];
            date = new String[trips.length];
            String[] saved = new String[trips.length];
            String splitcontents = "";


            //The arrays start, end, mode and date are what you can use in Google cards. Something like looping through the length of any of them, creating a google card for each i, and then
            //adding the same index values to each card.
            for (int i = 0; i < trips.length; i++) {
                trips[i] = trips[i].replaceAll("\\*", "*");
                String[] split = trips[i].split("\\*");
                start[i] = split[0];
                if (start[i].length() > 25) {
                    start[i] = start[i].substring(0, 24) + "...";
                }
                mode[i] = split[1];
                end[i] = split[2];
                if (end[i].length() > 25) {
                    end[i] = end[i].substring(0, 24) + "...";
                }
                date[i] = split[3];
                splitcontents += "Start = " + start[i] + " End = " + end[i] + " Mode = " + mode[i] + " Date = " + date[i];
                splitcontents += "\n";
                splitcontents += "\n";
                saved[i] = (Math.random() * 100 % 1) + "";
            }
//        //mtext.setText(splitcontents);
//        tstart.setText(start[start.length - 1]);
//        tend.setText(end[end.length - 1]);
//        tmode.setText(mode[mode.length - 1]);
//        tdate.setText(date[date.length - 1]);


            ArrayList<Model> list = new ArrayList<>();

            for (int i = start.length - 1; i > 0; i--) {
                Model imageModel = new Model();
                imageModel.setImage_drawable(R.drawable.ic_map);
                imageModel.setText1("From: " + start[i]);
                imageModel.setText2("To: " + end[i]);
                imageModel.setMode("Mode: " + mode[i]);
                list.add(imageModel);

            }

            return list;
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
