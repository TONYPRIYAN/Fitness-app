package com.example.shapeshift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class arms extends AppCompatActivity {
    ListView lst;

    String[] maintitle ={
            "Barbell Curl","Dumbbell curl","Hammer Curl","PushDown cable","SkullCrusher","Tricep Extension"
    };

    String[] subtitle ={
            "3 Sets x 10 Reps",
            "3 Sets x 10 Reps",
            "3 Sets x 10 Reps",
            "3 Sets x 10 Reps",
            "3 Sets x 10 Reps","3 Sets x 10 Reps",
    };

    Integer[] imgid={
            R.drawable.barbellcurl,R.drawable.dumbcurl,R.drawable.hammercurl,
            R.drawable.pushdown,R.drawable.skullcrusher,R.drawable.tricepextension,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arms);

        exercises adapter=new exercises(this, maintitle, subtitle,imgid);
        lst = (ListView)findViewById(R.id.list);
        lst.setAdapter(adapter);
    }
}