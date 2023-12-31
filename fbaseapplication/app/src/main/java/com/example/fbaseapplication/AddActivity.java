package com.example.fbaseapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {
EditText name,course,email,turl;
Button btnAdd,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name=(EditText)findViewById(R.id.txtname);
        course=(EditText)findViewById(R.id.txtcourse);
        email=(EditText)findViewById(R.id.txtemail);
        turl=(EditText)findViewById(R.id.txtImageurl);

        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnBack=(Button)findViewById(R.id.btnBack);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
insertData();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }

    private void insertData() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name.getText().toString());
        map.put("courses", course.getText().toString());
        map.put("email", email.getText().toString());
        map.put("turl", turl.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("teachers").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddActivity.this,"Data inserted successfully",Toast.LENGTH_LONG).show();
                    }
                })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AddActivity.this,"Error while insertion",Toast.LENGTH_LONG).show();
            }
        });
    }
}