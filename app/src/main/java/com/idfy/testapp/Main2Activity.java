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

        RelativeLayout relAadhaarFront = findViewById(R.id.aadhaar_front);
        RelativeLayout relAadhaarBack = findViewById(R.id.aadhaar_back);
        RelativeLayout reldriving_license = findViewById(R.id.driving_license);
        RelativeLayout relPan = findViewById(R.id.pan);
        RelativeLayout relvoter_front = findViewById(R.id.voter_front);
        RelativeLayout relvoter_back = findViewById(R.id.voter_back);
        RelativeLayout relpassport_front = findViewById(R.id.passport_front);
        RelativeLayout relpassport_back = findViewById(R.id.passport_back);

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

        reldriving_license.setOnClickListener(new View.OnClickListener() {
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

        relvoter_front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                i.putExtra("doc", "ind_voter_front");
                startActivity(i);
            }
        });

        relvoter_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                i.putExtra("doc", "ind_voter_back");
                startActivity(i);
            }
        });

        relpassport_front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                i.putExtra("doc", "ind_passport_front");
                startActivity(i);
            }
        });

        relpassport_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                i.putExtra("doc", "ind_passport_back");
                startActivity(i);
            }
        });
    }
}
