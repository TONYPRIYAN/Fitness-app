package com.example.shapeshift;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bmij extends AppCompatActivity
{
    EditText height,weight;
    TextView resultView;
    String calculation,BMIresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmij);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        resultView = (TextView) findViewById(R.id.result);




    }

    public void calculateBMI(View view) {
        String S1 = weight.getText().toString();
        String S2 = height.getText().toString();

        float weightValue = Float.parseFloat(S1);
        float heightValue = Float.parseFloat(S2) / 100;

        float bmi = weightValue / (heightValue * heightValue);

        if (bmi < 16) {
            BMIresult = "Severely under weight";
        } else if (bmi < 18.5) {
            BMIresult = "Under Weight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            BMIresult = "Normal Weight";
        } else if (bmi >= 25 && bmi <= 29.9) {
            BMIresult = "OverWeight";
        }else {
            BMIresult = "Obese";
        }

        calculation = "Result: \n\n" + bmi + "\n\n" + BMIresult;
        resultView.setText(calculation);

    }
}

