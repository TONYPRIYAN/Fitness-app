package com.example.shapeshift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class back extends AppCompatActivity {
    ListView lst;

    String[] maintitle ={
                    "Bentover","Deadlift","LatPullDown","Pullups","RopeRow",
    };

    String[] subtitle ={
            "4 Sets x 10 reps","4 Sets x 10 reps","4 Sets x 10 reps",
            "4 Sets x 10 reps","4 Sets x 10 reps",
    };

    Integer[] imgid={
            R.drawable.bentover,R.drawable.deadlift,R.drawable.latpulldown,
            R.drawable.pullups,R.drawable.roperow,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        exercises adapter=new exercises(this, maintitle, subtitle,imgid);
        lst = (ListView)findViewById(R.id.list);
        lst.setAdapter(adapter);
    }
}
