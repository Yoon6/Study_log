package com.example.sampleframelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView view1;
    ImageView view2;

    int imageIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view1 = findViewById(R.id.imageView);
        view2 = findViewById(R.id.imageView2);
    }

    public void onButton1Clicked(View view) {
        changeImage();
    }

    private void changeImage(){
        if(imageIndex == 0){
            view1.setVisibility(View.VISIBLE);
            view2.setVisibility(View.INVISIBLE);

            imageIndex=1;
        }else if(imageIndex == 1){
            view1.setVisibility(View.INVISIBLE);
            view2.setVisibility(View.VISIBLE);

            imageIndex=0;
        }
    }
}