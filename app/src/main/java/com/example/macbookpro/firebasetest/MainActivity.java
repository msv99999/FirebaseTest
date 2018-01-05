package com.example.macbookpro.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    EditText name,movie,food,hobby;
    Button submit,clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText) findViewById(R.id.et1);
        movie=(EditText) findViewById(R.id.et2);
        food=(EditText) findViewById(R.id.et3);
        hobby=(EditText) findViewById(R.id.et4);


        clear=(Button) findViewById(R.id.clear);
        submit=(Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase fd=FirebaseDatabase.getInstance();
                DatabaseReference dr=fd.getReference();

                Map<String, Object> map = new HashMap<String, Object>();

                DatabaseReference dr1=dr.child("Procode");
                DatabaseReference dr2=dr1.child(name.getText().toString());

                map.put("movie",movie.getText().toString());
                dr2.updateChildren(map);

                map.put("food",food.getText().toString());
                dr2.updateChildren(map);

                map.put("hobby",hobby.getText().toString());
                dr2.updateChildren(map);
                //
                Toast.makeText(getBaseContext(), "Thank you for your response", Toast.LENGTH_SHORT).show();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                food.setText("");
                movie.setText("");
                hobby.setText("");
                food.setText("");
            }
        });



    }
}
