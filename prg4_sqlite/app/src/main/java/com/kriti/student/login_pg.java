package com.kriti.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class login_pg extends AppCompatActivity {

    private EditText usn, pw;
    private Button submit;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pg);

        usn = findViewById(R.id.inUsn);
        pw = findViewById(R.id.inPw);
        submit = findViewById(R.id.submit);

        submit.setClickable(true);

        db = new DBHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String usnStr = usn.getText().toString();
                final String pwStr = pw.getText().toString();

                int num = db.checkPw(usnStr, pwStr);
                if(num > 0){
                    int ch = db.checkAdmin(usnStr);
                    if(ch==0){
                        Intent i = new Intent(view.getContext(), user_pg.class);
                        i.putExtra("usn", usnStr);
                        startActivity(i);
                    }
                    else{
                        Intent i = new Intent(view.getContext(), admin_pg.class);
                        startActivity(i);
                    }
                }

                else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Check username and password", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
