package com.kriti.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;


public class register_pg extends AppCompatActivity {

    private EditText password, usn, name;
    private DBHelper db;
    private Switch sw;
    private Integer admin;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pg);

        password = findViewById(R.id.inPw);
        usn = findViewById(R.id.inUsn);
        name = findViewById(R.id.inName);
        sw = findViewById(R.id.admin_sw);
        submit = findViewById(R.id.submit);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //the user is admin or not
                if (isChecked) {
                    admin = 1;
                }
                else {
                    admin = 0;
                }
            }
        });

        db = new DBHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String nameStr = name.getText().toString();
                final String pwStr = password.getText().toString();
                final String usnStr = usn.getText().toString();

                //no null value should be accepted
                if(nameStr.length() == 0 || usnStr.length() == 0 || pwStr.length() == 0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "no null variables accepted", Toast.LENGTH_SHORT);
                    toast.show();
                }

                else {
                    int num = db.getData(usnStr);
                    //to check if the USN already exist
                    if(num>0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "User already exist", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                    else {
                        Student st = new Student(nameStr,usnStr,pwStr,admin);
                        db.insertStudent(st);

                        Toast toast = Toast.makeText(getApplicationContext(), "registered successfully", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }

            }
        });

    }
}
