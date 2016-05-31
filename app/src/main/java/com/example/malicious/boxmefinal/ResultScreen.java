package com.example.malicious.boxmefinal;

import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ResultScreen extends ActionBarActivity {

    Button main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);


        TextView resLbl = (TextView)findViewById(R.id.resLbl);
        resLbl.setText(Double.toString(AcceptScreen.dimensional_weight));




    }







}