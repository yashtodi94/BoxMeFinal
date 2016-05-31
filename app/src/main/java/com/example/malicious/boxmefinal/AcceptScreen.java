package com.example.malicious.boxmefinal;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class AcceptScreen extends ActionBarActivity {

    public static EditText edit_length, edit_width, edit_height;                  //Declare variables of type EditText to store length, breadth, height
    public static double dimensional_weight;                                  //Variable to store final result in integer form

    Button proceedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_screen);
        init();
    }


    public void init() {


        //Accept length, breadth and height data from text fields in the app
        edit_length = (EditText) findViewById(R.id.lengthTF);
        edit_width = (EditText) findViewById(R.id.widthTF);
        edit_height = (EditText) findViewById(R.id.heigthTF);




        proceedButton = (Button) findViewById(R.id.proceedBtn);


        //Invoke the following function when proceed button is clicked------
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Convert dimensions to string type for internal purposes
                String length_str = edit_length.getText().toString();
                String width_str = edit_width.getText().toString();
                String height_str = edit_height.getText().toString();

                double length = Double.parseDouble(length_str);
                double width = Double.parseDouble(width_str);
                double height = Double.parseDouble(height_str);

                dimensional_weight = (length * width * height) / 5000;

                switch (v.getId())
                {
                    case R.id.proceedBtn:
                        Intent intent = getIntent();


                        Intent i = new Intent(AcceptScreen.this, ResultScreen.class);
                        Bundle bundle = new Bundle();
                        bundle.putDouble("result1",dimensional_weight);
                        i.putExtras(bundle);
                        startActivity(i);
                        break;
                }








            }
        });

        //Formula to calculate dimensional weight-----
    }
}
