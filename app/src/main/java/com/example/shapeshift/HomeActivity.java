package com.example.shapeshift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    ImageView BMI;
    ImageView Workout;
    ImageView Weight;
    ImageView Workoutlog;
    ImageView Water;
    ImageView Calorie;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemid = item.getItemId();
        if (itemid == R.id.action_about_us) {

            showAboutUs();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }


    private void showAboutUs() {
        Intent intent = new Intent(this, Aboutus.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BMI = (ImageView) findViewById(R.id.bmi);
        Workout = (ImageView) findViewById(R.id.workout);
        Weight = (ImageView) findViewById(R.id.weightlog);
        Workoutlog = (ImageView) findViewById(R.id.workoutlog);
        Water = (ImageView) findViewById(R.id.water);
        Calorie = (ImageView) findViewById(R.id.calorie);

        BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, bmij.class);
                startActivity(intent);
            }
        });

        Workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, Workoutj.class);
                startActivity(intent);
            }
        });

        Weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, weightj.class);
                startActivity(intent);
            }
        });

        Workoutlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, workoutlog.class);
                startActivity(intent);
            }
        });

        Water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, waterintake.class);
                startActivity(intent);
            }
        });

        Calorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.calories.info/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}






