package com.example.adi.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText e1;
    private EditText e2;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 =(Button) findViewById(R.id.b1);
        final EditText e1 = (EditText) findViewById(R.id.et1);
        final EditText e2 = (EditText) findViewById(R.id.et2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();
                if(TextUtils.isEmpty(str1)){
                    e1.setError("Please enter your weight");
                    e1.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(str2)){
                    e2.setError("Please enter your height");
                    e2.requestFocus();
                    return;
                }
                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2)/100;
                float bmiValue = calculateBMI(weight, height);
                String bmiInterpretation = interpretBMI(bmiValue);
                Intent i = new Intent();
                i.setClass(MainActivity.this,Main2Activity.class);
                i.putExtra("TEXT",bmiInterpretation);
                i.putExtra("BMI",bmiValue);
                startActivity(i);

            }
        });

    }

    private float calculateBMI(float weight, float height) {
        return (float) (weight / (height * height));
    }
    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
