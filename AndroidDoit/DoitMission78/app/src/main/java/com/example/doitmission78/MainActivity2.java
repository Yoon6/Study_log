package com.example.doitmission78;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {
    public static final int REQUEST_CODE_SUB1 = 2221;
    public static final int REQUEST_CODE_SUB2 = 2222;
    public static final int REQUEST_CODE_SUB3 = 2223;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void sub1Clicked(View view) {
        Intent intent = new Intent(this, SubActivity1.class);
        startActivityForResult(intent, REQUEST_CODE_SUB1);

    }

    public void sub2Clicked(View view) {
        Intent intent = new Intent(this, SubActivity2.class);
        startActivityForResult(intent, REQUEST_CODE_SUB2);
    }

    public void sub3Clicked(View view) {
        Intent intent = new Intent(this, SubActivity3.class);
        startActivityForResult(intent, REQUEST_CODE_SUB3);
    }
}