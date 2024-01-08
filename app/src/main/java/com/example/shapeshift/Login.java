package com.example.shapeshift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity{
FirebaseFirestore firestore;
EditText E1,E2;
        Button B1;


@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firestore = FirebaseFirestore.getInstance();

        E1 = (EditText) findViewById(R.id.editTextText);
        E2 = (EditText) findViewById(R.id.editTextTextPassword);
        B1 = (Button) findViewById(R.id.button);

        B1.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
//        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
//        startActivity(i);
        if(E1.getText().toString().length() == 0)
        {
                E1.setError("Enter your name");
                E1.requestFocus();
        } else if (E2.getText().toString().length() == 0) {
                E2.setError("Enter Password");
                E2.requestFocus();

        }
        else {

                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                //i.putExtra("name",(CharSequence) E1);
                startActivity(i);


                String username = E1.getText().toString();
                String password = E2.getText().toString();


                Map<String, Object> userData = new HashMap<>();
                userData.put("username", username);
                userData.put("password", password);


                firestore.collection("users")
                        .add(userData)
                        .addOnSuccessListener(documentReference -> {

                                E1.setText("");
                                E2.setText("");
                                Toast.makeText(getApplicationContext(),"Logged in",Toast.LENGTH_LONG).show();

                        })
                        .addOnFailureListener(e -> {
                                Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();
                        });


        }
}
        });



        }
}