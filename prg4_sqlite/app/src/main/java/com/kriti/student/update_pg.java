package com.kriti.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class update_pg extends AppCompatActivity {

    private EditText usn, password;
    private Button update;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pg);

        usn = findViewById(R.id.inUsn);
        password = findViewById(R.id.inPw);
        update = findViewById(R.id.update);
        db = new DBHelper(this);

        update.setClickable(true);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usnStr = usn.getText().toString();
                String pwStr = password.getText().toString();
                Student st = db.getStudent(usnStr);
                st.setPassword(pwStr);
                db.updateStudent(st);

                Intent i = new Intent(view.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
