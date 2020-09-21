package com.example.mission_ch2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;

public class misson4 extends AppCompatActivity {

    EditText edt_message;
    TextView txt_size;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission4);

        edt_message = findViewById(R.id.edt_message);
        txt_size = findViewById(R.id.txt_size);

        Button sendButton = findViewById(R.id.btn_send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message = edt_message.getText().toString(); // editText메세지 받아오기
                Toast.makeText(getApplicationContext(), "전송할 메시지\n\n" + message, Toast.LENGTH_LONG).show(); // 토스트 표시
            }
        });

        Button closeButton = findViewById(R.id.btn_close);
        closeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish(); // 액티비티 끝내기
            }
        });

        TextWatcher watcher = new TextWatcher() { // 변화 감지
            public void onTextChanged(CharSequence str, int start, int before, int count) { // 텍스타가 바뀌면
                byte[] bytes = null;
                try {
                    bytes = str.toString().getBytes("KSC5601");
                    int strCount = bytes.length; // 바이트 길이
                    txt_size.setText(strCount + " / 80바이트"); // Set textView
                } catch(UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void afterTextChanged(Editable strEditable) {
                String str = strEditable.toString();
                try {
                    byte[] strBytes = str.getBytes("KSC5601");
                    if(strBytes.length > 80) {
                        strEditable.delete(strEditable.length()-2, strEditable.length()-1);
                    }
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        edt_message.addTextChangedListener(watcher); // editText에 watcher추가
    }
}
