package com.kriti.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class user_pg extends AppCompatActivity {

    private TextView TV;
    private Button back;
    private DBHelper db;
    private String usn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pg);

        back = findViewById(R.id.back);
        TV = findViewById(R.id.TV);
        db = new DBHelper(this);

        Intent i = getIntent();
        usn = i.getStringExtra("usn");

        Student st = db.getStudent(usn);

        TV.setText("Welcome "+st.getName()+"!");

        back.setClickable(true);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
