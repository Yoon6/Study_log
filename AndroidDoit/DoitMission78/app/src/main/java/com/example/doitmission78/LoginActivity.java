package com.example.doitmission78;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public static final int RESULT_OK=1111;
    EditText id;
    EditText pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id=findViewById(R.id.editTextTextPersonName);
        pw=findViewById(R.id.editTextTextPersonName2);

        Button button = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id.getText().toString().equals("")||pw.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "입력하세요", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivityForResult(intent, RESULT_OK);
                }
            }
        });
    }
}