package com.kriti.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class delete_pg extends AppCompatActivity {

    private EditText usn;
    private Button delete;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_pg);

        usn = findViewById(R.id.inUsn);
        delete = findViewById(R.id.delete);

        delete.setClickable(true);
        db = new DBHelper(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usnStr = usn.getText().toString();
                Boolean del;

                del = db.deleteUsn(usnStr);
                if(del == true){
                    Toast toast = Toast.makeText(getApplicationContext(), "Data deleted", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Data not deleted", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
