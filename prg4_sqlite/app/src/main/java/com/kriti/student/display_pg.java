package com.kriti.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class display_pg extends AppCompatActivity {
    private ListView dataList;
    private ArrayAdapter<String> listAdapter ;
    private Button back;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_pg);

        dataList = findViewById(R.id.dataList);
        back = findViewById(R.id.back);
        db = new DBHelper(this);

        back.setClickable(true);

        List<Student> student = db.getAllStudent();

        String[] datas = new String[student.size()];

        for (int i=0; i<student.size(); i++) {
            datas[i] = student.get(i).getUsn()+": "+student.get(i).getName();
        }
        ArrayList<String> stList = new ArrayList<String>();
        stList.addAll( Arrays.asList(datas) );

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.view_file, stList);

        // Set the ArrayAdapter as the ListView's adapter.
        dataList.setAdapter( listAdapter );

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
