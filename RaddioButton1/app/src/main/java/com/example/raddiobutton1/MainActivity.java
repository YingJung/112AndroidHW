package com.example.raddiobutton1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    TextView output; // 声明TextView对象
    RadioGroup rgGender; // 声明RadioGroup对象
    RadioGroup rgType; // 声明RadioGroup对象
    EditText editTextNumber; // 声明EditText对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 找到TextView对象并注册监听器
        output = findViewById(R.id.lblOutput);
        rgGender = findViewById(R.id.rgGender);
        rgType = findViewById(R.id.rgType);
        editTextNumber = findViewById(R.id.editTextNumber);

        // 设置选择变化监听器
        rgGender.setOnCheckedChangeListener(this);
        rgType.setOnCheckedChangeListener(this);

        // 设置EditText文本变化监听器
        editTextNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // 当票数发生变化时更新文本内容
                calculatePriceAndDisplay();
            }
        });

        // 找到按钮并设置点击事件监听器
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 获取 TextView 中的文本内容
                String ticketInfo = output.getText().toString();

                // 创建 Intent 并传递购票信息到下一个页面
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                intent.putExtra("ticketInfo", ticketInfo);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        // 当选择发生变化时更新文本内容
        calculatePriceAndDisplay();
    }

    private void calculatePriceAndDisplay() {
        // 获取票数
        int numberOfTickets = 0;
        try {
            numberOfTickets = Integer.parseInt(editTextNumber.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        // 获取性别
        String gender = "";
        int genderCheckedId = rgGender.getCheckedRadioButtonId();
        if (genderCheckedId == R.id.rdbBoy) {
            gender = "男";
        } else if (genderCheckedId == R.id.rdbGirl) {
            gender = "女";
        }

        // 获取票类型
        String ticketType = "";
        int typeCheckedId = rgType.getCheckedRadioButtonId();
        int price = 0;
        if (typeCheckedId == R.id.rdbAdult) {
            ticketType = "全票(500)";
            price = 500;
        } else if (typeCheckedId == R.id.rdbChild) {
            ticketType = "兒童票(250)";
            price = 250;
        } else if (typeCheckedId == R.id.rdbStudent) {
            ticketType = "學生票(400)";
            price = 400;
        }

        // 计算总价
        int totalPrice = price * numberOfTickets;

        // 更新文本视图的内容
        String displayText = gender + " "  + ticketType + " " + numberOfTickets + " 張, 總價格: " + totalPrice;
        output.setText(displayText);
    }


}


