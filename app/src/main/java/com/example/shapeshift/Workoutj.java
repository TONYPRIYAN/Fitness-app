package com.example.shapeshift;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Workoutj extends AppCompatActivity {
    ListView lst;

    String[] maintitle ={
            "Chest","Back",
            "Shoulder","Arm","Legs","Abs"
    };

    String[] subtitle ={
            "5 exercise","5 exercise","5 exercise","6 exercise","5 exercise","4 exercise",
    };

    Integer[] imgid={
            R.drawable.chest3,R.drawable.back5,R.drawable.shoulder3,
            R.drawable.arm4,R.drawable.leg4,R.drawable.abs4,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutj);

        workout2j adapter=new workout2j(this, maintitle, subtitle,imgid);
        lst=(ListView)findViewById(R.id.list);
        lst.setAdapter(adapter);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {

                    Intent intent = new Intent(Workoutj.this, chest.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Chest",Toast.LENGTH_SHORT).show();
                }

                else if(position == 1) {
                    Intent intent = new Intent(Workoutj.this, back.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Back",Toast.LENGTH_SHORT).show();
                }

                else if(position == 2) {
                    Intent intent = new Intent(Workoutj.this, shoulder.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Shoulder",Toast.LENGTH_SHORT).show();
                }
                else if(position == 3) {
                    Intent intent = new Intent(Workoutj.this, arms.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Arm",Toast.LENGTH_SHORT).show();
                }
                else if(position == 4) {
                    Intent intent = new Intent(Workoutj.this, legs.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Leg",Toast.LENGTH_SHORT).show();
                }
                else if(position == 5) {
                    Intent intent = new Intent(Workoutj.this, abs.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Abs",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}