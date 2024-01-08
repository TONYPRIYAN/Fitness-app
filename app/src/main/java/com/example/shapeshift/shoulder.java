package com.example.shapeshift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class shoulder extends AppCompatActivity {
    ListView lst;

    String[] maintitle ={
            "Shoulder Press","Rear Delt","Lateral Raise","Front Raise","Facepull",
    };

    String[] subtitle ={
            "4 Sets x 10 reps","4 Sets x 10 reps","4 Sets x 10 reps",
            "4 Sets x 10 reps","4 Sets x 10 reps",
    };

    Integer[] imgid={
            R.drawable.shoulderpress,R.drawable.reardelt,R.drawable.lateralraise,
            R.drawable.frontraise,R.drawable.facepull,
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