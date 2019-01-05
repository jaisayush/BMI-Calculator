package com.example.adi.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView tV;
    private TextView tV1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        Float BMI = i.getFloatExtra("BMI",0);
        String value = i.getStringExtra("TEXT");
        TextView tV= (TextView) findViewById(R.id.tV5);
        TextView tV1= (TextView)

                findViewById(R.id.tV6);
        tV1.setText(String.valueOf(BMI),TextView.BufferType.EDITABLE);
        String value3="You are, "+value;
        tV.setText(value3);
    }
}
