package com.example.foodimgmenu;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView image1,image2,image3,image4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        image1 =(ImageView) findViewById(R.id.output1);
        image2 =(ImageView) findViewById(R.id.output2);
        image3 =(ImageView) findViewById(R.id.output3);
        image4 =(ImageView) findViewById(R.id.output4);


       // TextView tx1 = (TextView)findViewById(R.id.tx1);
        //tx1.setText(msg);
        CheckBox.OnCheckedChangeListener checkBoxListener = (buttonView, isChecked) -> {
            // 检查哪个复选框被点击
            if (buttonView.getId() == R.id.chk1) {
                if (isChecked) {
                    // 如果复选框1被选中，显示图片1，否则隐藏
                    image1.setVisibility(View.VISIBLE);
                } else {
                    image1.setVisibility(View.GONE);
                }
            }
            if (buttonView.getId() == R.id.chk2) {
                if (isChecked) {
                    // 如果复选框1被选中，显示图片1，否则隐藏
                    image2.setVisibility(View.VISIBLE);
                } else {
                    image2.setVisibility(View.GONE);
                }
            }
            if (buttonView.getId() == R.id.chk3) {
                if (isChecked) {
                    // 如果复选框1被选中，显示图片1，否则隐藏
                    image3.setVisibility(View.VISIBLE);
                } else {
                    image3.setVisibility(View.GONE);
                }
            }
            if (buttonView.getId() == R.id.chk4) {
                if (isChecked) {
                    // 如果复选框1被选中，显示图片1，否则隐藏
                    image4.setVisibility(View.VISIBLE);
                } else {
                    image4.setVisibility(View.GONE);
                }
            }

        };

        // 为每个复选框设置共享的点击监听器
        CheckBox chk1 = findViewById(R.id.chk1);
        CheckBox chk2 = findViewById(R.id.chk2);
        CheckBox chk3 = findViewById(R.id.chk3);
        CheckBox chk4 = findViewById(R.id.chk4);

        chk1.setOnCheckedChangeListener(checkBoxListener);
        chk2.setOnCheckedChangeListener(checkBoxListener);
        chk3.setOnCheckedChangeListener(checkBoxListener);
        chk4.setOnCheckedChangeListener(checkBoxListener);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}