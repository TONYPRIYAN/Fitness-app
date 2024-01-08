package com.example.shapeshift;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class workoutlog extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private int selectedDuration = 0;
    private List<String> workoutLogs = new ArrayList<>();
    private ArrayAdapter<String> listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutlog);

        sharedPreferences = getSharedPreferences("WorkoutLog", Context.MODE_PRIVATE);

        final DatePicker datePicker = findViewById(R.id.datePicker);
        final TextView textViewDuration = findViewById(R.id.textViewDuration);
        SeekBar seekBar = findViewById(R.id.seekBar);
        final Button buttonSave = findViewById(R.id.buttonSave);
        final ListView listView = findViewById(R.id.listView);

        seekBar.setMax(240);

        listViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, workoutLogs);
        listView.setAdapter(listViewAdapter);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                selectedDuration = progress;
                textViewDuration.setText(selectedDuration + " minutes");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Not used
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Not used
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int year = datePicker.getYear();
                int month = datePicker.getMonth();
                int day = datePicker.getDayOfMonth();

                String workoutDate = year + "-" + (month + 1) + "-" + day;
                String workoutDuration = formatDuration(selectedDuration);

                // Save the workout log using SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Date", workoutDate);
                editor.putString("Duration", workoutDuration);
                editor.apply();

                // Add the workout log to the list and update the ListView
                workoutLogs.add(workoutDate + " - " + workoutDuration);
                listViewAdapter.notifyDataSetChanged();
            }
        });
    }

    private String formatDuration(int minutes) {
        if (minutes < 60) {
            return minutes + " minutes";
        } else {
            int hours = minutes / 60;
            int remainingMinutes = minutes % 60;
            if (remainingMinutes > 0) {
                return hours + " hours " + remainingMinutes + " minutes";
            } else {
                return hours + " hours";
            }
        }
    }
}