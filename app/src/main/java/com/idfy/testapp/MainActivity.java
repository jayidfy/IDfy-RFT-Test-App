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

    private Bitmap currentImage;
    private ProgressDialog progressDialog;
    private ImageView image;
    private static String currentValue = "ind_aadhaar_front";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        currentValue = i.getStringExtra("doc");

        image = findViewById(R.id.image);
        Button buttonDocCapture = findViewById(R.id.button_doc_capture);
        Button buttonFaceCapture = findViewById(R.id.button_face_capture);
        Button buttonSubmit = findViewById(R.id.button_submit);
        TextView textViewHeader = findViewById(R.id.text_view_header);
        textViewHeader.setText(currentValue);

        final RFTSdk rftsdk = RFTSdk.init(MainActivity.this, "PLACE_YOUR_ACCOUNT_ID_HERE", "PLACE_YOUR_TOKEN_HERE");

        buttonDocCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rftsdk.CaptureDocImage(MainActivity.this, currentValue, MainActivity.this);
            }
        });

        buttonFaceCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rftsdk.CaptureFaceImage(MainActivity.this, MainActivity.this);
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setMessage("Please wait");
                    progressDialog.show();
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
        image.setImageBitmap(bitmap);
    }

    @Override
    public void onImageCaptureFaliure(JSONObject jsonObject) {
        Log.d("LOG", jsonObject.toString());
    }

    private class AsyncReq extends AsyncTask<Void, Void, JSONObject> {

        RFTSdk rftsdk;

        AsyncReq(RFTSdk instance) {
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
                progressDialog.dismiss();
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            super.onPostExecute(jsonObject);
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, "Upload Success, Response-> " + jsonObject.toString(), Toast.LENGTH_LONG).show();
        }
    }
}