package com.example.shapeshift;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class weightj extends Activity {
    private DatePicker datePicker;
    private EditText editTextWeight;
    private Button buttonAdd;
    private ListView listViewEntries;
    private ArrayAdapter<String> entriesAdapter;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weightj);

        datePicker = findViewById(R.id.datePicker);
        editTextWeight = findViewById(R.id.editTextWeight);
        buttonAdd = findViewById(R.id.buttonAdd);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        entriesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();
                String weight = editTextWeight.getText().toString();

                if (!weight.isEmpty()) {
                    // Save the date and weight to SharedPreferences
                    saveWeightEntry(day, month, year, weight);

                    // Update the entries list
                    loadWeightEntries();
                    editTextWeight.setText(""); // Clear the weight input
                }
            }
        });

        listViewEntries = findViewById(R.id.listViewEntries);
        listViewEntries.setAdapter(entriesAdapter);
    }

    private void saveWeightEntry(int day, int month, int year, String weight) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> entries = sharedPreferences.getStringSet("weight_entries", new HashSet<String>());

        // Format the date as a string and store it along with the weight
        String entry = String.format("%04d-%02d-%02d: %s", year, month + 1, day, weight);
        entries.add(entry);

        editor.putStringSet("weight_entries", entries);
        editor.apply();
    }

    private void loadWeightEntries() {
        Set<String> entries = sharedPreferences.getStringSet("weight_entries", new HashSet<String>());
        ArrayList<String> entryList = new ArrayList<>(entries);
        entriesAdapter.clear();
        entriesAdapter.addAll(entryList);
        entriesAdapter.notifyDataSetChanged();
    }
}