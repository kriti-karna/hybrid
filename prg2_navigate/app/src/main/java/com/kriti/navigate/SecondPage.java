package com.kriti.navigate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondPage extends AppCompatActivity {

    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        display = findViewById(R.id.name);

        Intent i = getIntent();
        final String Name = i.getStringExtra("Name");

        String msg;
        msg = "Hello " + Name;

        display.setText(msg);
    }
}