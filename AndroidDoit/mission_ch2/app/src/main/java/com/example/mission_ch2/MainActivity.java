package com.example.mission_ch2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView_top;
    ScrollView scrollView_bottom;

    ImageView imageView_top;
    ImageView imageView_bottom;

    private static boolean isChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView_top = findViewById(R.id.image_top);
        imageView_bottom = findViewById(R.id.image_bottom);

        scrollView_top = findViewById(R.id.scroll1);
        scrollView_bottom = findViewById(R.id.scroll2);

        scrollView_top.setHorizontalScrollBarEnabled(true);
        scrollView_bottom.setHorizontalScrollBarEnabled(true);

    }

    public void onButtonClicked(View view) {
        if(!isChange){
            imageView_top.setVisibility(View.VISIBLE);
            imageView_bottom.setVisibility(View.INVISIBLE);

            isChange=true;
        }else{
            imageView_top.setVisibility(View.INVISIBLE);
            imageView_bottom.setVisibility(View.VISIBLE);

            isChange=false;
        }
    }

}