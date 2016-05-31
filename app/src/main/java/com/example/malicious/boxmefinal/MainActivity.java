package com.example.malicious.boxmefinal;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.Toast;


import java.net.URI;


public class MainActivity extends ActionBarActivity {

    Button set1;                                        //Declare button to invoke acceptscreen
    ImageButton start;                                  //Declare button to invoke camera
    ImageButton phone;                                  //Declare button to invoke phone
    ImageButton gallery;
    private static final int CAMERA_REQUEST = 1888;
    private static int RESULT_LOAD_IMAGE = 1;
    String imgDecodableString;
    ImageView imgv4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        set1 = (Button) findViewById(R.id.XBtn);                     //For X Button
        start = (ImageButton) findViewById(R.id.startBtn);           //For Start button
        phone = (ImageButton) findViewById(R.id.phoneBtn);            //For phone button
        gallery = (ImageButton) findViewById(R.id.galleryBtn);
        imgv4 = (ImageView) findViewById(R.id.imgv4);

        //Functionality to handle X button
        set1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent accept = new Intent(MainActivity.this, AcceptScreen.class);
                startActivity(accept);
            }
        });

        //Functionality to handle phone button
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotophone = new Intent(MainActivity.this, NumActivity.class);
                startActivity(gotophone);
            }
        });

        //functionality to import image from gallery
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
            }
        });


        //Functionality to handle start button

        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);

            }
        });

    }
    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data)
        {
            Uri selectedImage = data.getData();
            imgv4.setImageURI(selectedImage);



        }
    }
}
