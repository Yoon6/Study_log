package com.example.doitmission78;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void setOnClick1(View view) {
        Intent intent = new Intent();
        intent.putExtra("name", "고객 관리");
        setResult(1111, intent);
        finish();
    }

    public void setOnClick2(View view) {
        Intent intent = new Intent();
        intent.putExtra("name", "매출 관리");
        setResult(1111, intent);
        finish();
    }

    public void setOnClick3(View view) {
        Intent intent = new Intent();
        intent.putExtra("name", "상품 관리");
        setResult(1111, intent);
        finish();
    }
}