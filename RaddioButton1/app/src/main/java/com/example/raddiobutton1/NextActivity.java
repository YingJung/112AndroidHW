package com.example.raddiobutton1;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_activity);

        // 获取 Intent 中的购票信息
        Intent intent = getIntent();
        String ticketInfo = intent.getStringExtra("ticketInfo");

        // 在界面上显示购票信息
        TextView textView = findViewById(R.id.textView4);
        textView.setText(ticketInfo);
    }
}