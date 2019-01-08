package com.idfy.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RelativeLayout relAadhaarFront = findViewById(R.id.relative_layout_aadhaar_front);
        RelativeLayout relAadhaarBack = findViewById(R.id.relative_layout_aadhaar_back);
        RelativeLayout relDrivingLicense = findViewById(R.id.relative_layout_driving_license);
        RelativeLayout relPan = findViewById(R.id.relative_layout_pan);
        RelativeLayout relVoterFront = findViewById(R.id.relative_layout_voter_front);
        RelativeLayout relVoterBack = findViewById(R.id.relative_layout_voter_back);
        RelativeLayout relPassportFront = findViewById(R.id.relative_layout_passport_front);
        RelativeLayout relPassportBack = findViewById(R.id.relative_layout_passport_back);

        relAadhaarFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                i.putExtra("doc", "ind_aadhaar_front");
                startActivity(i);
            }
        });

        relAadhaarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                i.putExtra("doc", "ind_aadhaar_back");
                startActivity(i);
            }
        });

        relDrivingLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                i.putExtra("doc", "ind_driving_license");
                startActivity(i);
            }
        });

        relPan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                i.putExtra("doc", "ind_pan");
                startActivity(i);
            }
        });

        relVoterFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                i.putExtra("doc", "ind_voter_front");
                startActivity(i);
            }
        });

        relVoterBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                i.putExtra("doc", "ind_voter_back");
                startActivity(i);
            }
        });

        relPassportFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                i.putExtra("doc", "ind_passport_front");
                startActivity(i);
            }
        });

        relPassportBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                i.putExtra("doc", "ind_passport_back");
                startActivity(i);
            }
        });
    }
}