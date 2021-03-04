package com.kriti.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class insert_pg extends AppCompatActivity {

    private EditText name, usn, pw;
    private Button insert;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_pg);

        name = findViewById(R.id.inName);
        usn = findViewById(R.id.inUsn);
        pw = findViewById(R.id.inPw);
        insert = findViewById(R.id.insert);

        insert.setClickable(true);

        db = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr = name.getText().toString();
                String usnStr = usn.getText().toString();
                String pwStr = pw.getText().toString();
                int admin = 0;
                Student st = new Student(nameStr, usnStr, pwStr, admin);
                db.insertStudent(st);

                Intent i = new Intent(view.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
