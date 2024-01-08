package com.example.shapeshift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class abs extends AppCompatActivity {
    ListView lst;

    String[] maintitle ={
            "AbWheel","Kneeling Crunch","SideBend","Situps"
    };

    String[] subtitle ={
            "4 Sets x 10 reps","4 Sets x 10 reps","4 Sets x 10 reps",
            "4 Sets x 10 reps",
    };

    Integer[] imgid={
            R.drawable.abwheel,R.drawable.kneelingcrunch,R.drawable.sidebend,
            R.drawable.situps,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs);

        exercises adapter=new exercises(this, maintitle, subtitle,imgid);
        lst = (ListView)findViewById(R.id.list);
        lst.setAdapter(adapter);
    }
}
