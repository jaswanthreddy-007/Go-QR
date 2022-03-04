package com.example.qrcoder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {
    EditText et;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.et);
        iv = findViewById(R.id.iv);


    }
    public void get(View view) {
        et = findViewById(R.id.et);
        iv = findViewById(R.id.iv);

        String text = et.getText().toString();
        String url = "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data="+et;
        Glide.with(MainActivity.this)
                .load(url)
                .apply(new RequestOptions().override(500,500))
                .into(iv);
    }

}