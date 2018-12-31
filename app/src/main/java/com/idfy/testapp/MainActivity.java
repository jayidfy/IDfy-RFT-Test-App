package com.idfy.testapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.idfy.rft.RFTSdk;
import com.idfy.rft.RftSdkCallbackInterface;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements RftSdkCallbackInterface {

    Bitmap currentImage;
    ProgressDialog dail;
    ImageView img;
    static String currentValue = "ind_aadhaar_front";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        currentValue = i.getStringExtra("doc");

        img = findViewById(R.id.image);
        Button btn = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        TextView txtheader = findViewById(R.id.textView);

        txtheader.setText(currentValue);

        final RFTSdk rftsdk = RFTSdk.init(MainActivity.this, "PLACE_YOUR_ACCOUNT_ID_HERE", "PLACE_YOUR_TOKEN_HERE");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rftsdk.CaptureDocImage(MainActivity.this, currentValue, MainActivity.this);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rftsdk.CaptureFaceImage(MainActivity.this, MainActivity.this);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dail = new ProgressDialog(MainActivity.this);
                    dail.setMessage("Please wait");
                    dail.show();
                    new AsyncReq(rftsdk).execute();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    public void onImageCaptureSuccess(Bitmap bitmap) {
        //Use the result image as required
        currentImage = bitmap;
        img.setImageBitmap(bitmap);
    }

    @Override
    public void onImageCaptureFaliure(JSONObject jsonObject) {
        Log.d("LOG", jsonObject.toString());
    }

    private class AsyncReq extends AsyncTask<Void, Void, JSONObject> {

        RFTSdk rftsdk;

        public AsyncReq(RFTSdk instance) {
            this.rftsdk = instance;
        }

        @Override
        protected JSONObject doInBackground(Void... voids) {

            JSONObject result = null;
            try {
                result = rftsdk.UploadImage("PLACE_YOUR_ACCOUNT_ID_HERE",
                        "PLACE_YOUR_TOKEN_HERE",
                        "PLACE_YOUR_GROUP_ID_HERE",
                        "ind_amit", currentImage);
            } catch (Exception e) {
                dail.dismiss();
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            super.onPostExecute(jsonObject);
            dail.dismiss();
            Toast.makeText(MainActivity.this, "Upload succes, Response-> " + jsonObject.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
