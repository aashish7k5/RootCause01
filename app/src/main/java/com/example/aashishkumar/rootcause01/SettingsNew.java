package com.example.aashishkumar.rootcause01;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class SettingsNew extends AppCompatActivity {

    public EditText city;
    public EditText home;
    public EditText office;
    public TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_new);
        city = (EditText) findViewById(R.id.startcity);
        home = (EditText) findViewById(R.id.homecity);
        office = (EditText) findViewById(R.id.officecity);
        text = (TextView) findViewById(R.id.warning);

        String content = "";
        Scanner in = null;
        try {
            in = new Scanner(MainActivity.settings);
            while (in.hasNextLine())
            {
                content += in.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(!content.equals(""))
        {
            content = content.replaceAll("\\*", "*");
            String[] split = content.split("\\*");
            city.setText(split[0]);
            home.setText(split[1]);
            office.setText(split[2]);
        }
    }

    public void Submit(View view) throws IOException {
        city = (EditText) findViewById(R.id.startcity);
        home = (EditText) findViewById(R.id.homecity);
        office = (EditText) findViewById(R.id.officecity);
        text = (TextView) findViewById(R.id.warning);

        if(city.getText().length() == 0 || home.getText().length() == 0 || office.length() == 0)
        {
            text.setText("Please input all the parameters to submit");
            text.setTextColor(Color.RED);
            return;
        }
        else
        {
            text.setTextColor(Color.BLACK);
            text.setText("");
        }
        String complete = "";
        complete += city.getText(); complete += "*"; complete += home.getText(); complete += "*"; complete += office.getText() + "*";
        try {
            FileOutputStream stream = new FileOutputStream(MainActivity.settings, false);
            try{
                stream.write(complete.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String contents = "";
        Scanner in = new Scanner(MainActivity.settings);
        while (in.hasNextLine())
        {
            contents += in.nextLine();
        }
        text.setText(contents);
    }
}
