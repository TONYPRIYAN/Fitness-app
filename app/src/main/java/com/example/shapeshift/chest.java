package com.example.shapeshift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class chest extends AppCompatActivity {
    ListView lst;

    String[] maintitle ={
            "Incline Bench Press(Dumbbell)","Bench Press(Barbell)","Pec Deck Fly(Machine)",
            "Chest Dip","Push-up"
    };

    String[] subtitle ={
            "4 Sets x 10 reps","4 Sets x 10 reps","4 Sets x 10 reps",
            "4 Sets x 10 reps","4 Sets x 10 reps",
    };

    Integer[] imgid={
            R.drawable.inclinepress,R.drawable.barbell,R.drawable.pecfly,
            R.drawable.dips,R.drawable.pushups,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

        exercises adapter=new exercises(this, maintitle, subtitle,imgid);
        lst = (ListView)findViewById(R.id.list);
        lst.setAdapter(adapter);
    }
}