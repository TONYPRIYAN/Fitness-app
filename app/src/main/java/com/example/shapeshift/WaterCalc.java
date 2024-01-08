package com.example.shapeshift;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WaterCalc extends AppCompatActivity {

    private EditText editTextWeight;
    private Spinner spinnerActivity, spinnerClimate;
    private Button btnCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_calc);

        editTextWeight = findViewById(R.id.editTextWeight);
        spinnerActivity = findViewById(R.id.spinnerActivity);
        spinnerClimate = findViewById(R.id.spinnerClimate);
        btnCalculate = findViewById(R.id.btnCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        // Populate spinners with data
        ArrayAdapter<CharSequence> activityAdapter = ArrayAdapter.createFromResource(
                this, R.array.activity_levels, android.R.layout.simple_spinner_item);
        activityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerActivity.setAdapter(activityAdapter);

        ArrayAdapter<CharSequence> climateAdapter = ArrayAdapter.createFromResource(
                this, R.array.climate_types, android.R.layout.simple_spinner_item);
        climateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClimate.setAdapter(climateAdapter);

        // Calculate button click event
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateWaterIntake();
            }
        });
    }

    private void calculateWaterIntake() {
        // Retrieve user inputs
        double weight = Double.parseDouble(editTextWeight.getText().toString());
        String activityLevel = spinnerActivity.getSelectedItem().toString();
        String climate = spinnerClimate.getSelectedItem().toString();

        // Perform calculation based on user inputs (you can replace this with your own logic)
        double waterIntake = calculateWaterIntakeBasedOnInput(weight, activityLevel, climate);

        // Display the result
        textViewResult.setText(String.format("Recommended water intake: %.2f liters", waterIntake));
    }

    private double calculateWaterIntakeBasedOnInput(double weight, String activityLevel, String climate) {
        // Replace this with your own logic to calculate water intake based on weight, activity, and climate
        // This is just a placeholder example
        double baseIntake = weight * 0.03; // Replace with your own formula
        double activityMultiplier = getActivityMultiplier(activityLevel);
        double climateMultiplier = getClimateMultiplier(climate);

        return baseIntake * activityMultiplier * climateMultiplier;
    }

    private double getActivityMultiplier(String activityLevel) {
        // Replace this with your own logic
        // This is just a placeholder example
        switch (activityLevel) {
            case "Low":
                return 1.0;
            case "Moderate":
                return 1.5;
            case "High":
                return 2.0;
            default:
                return 1.0;
        }
    }

    private double getClimateMultiplier(String climate) {
        // Replace this with your own logic
        // This is just a placeholder example
        switch (climate) {
            case "Cold":
                return 0.8;
            case "Normal":
                return 1.0;
            case "Hot":
                return 1.2;
            default:
                return 1.0;
        }
    }
}