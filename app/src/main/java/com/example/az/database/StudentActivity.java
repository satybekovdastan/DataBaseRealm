package com.example.az.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentActivity extends AppCompatActivity {

    EditText edit_name;
    EditText edit_course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        edit_name = findViewById(R.id.edit_name);
        edit_course = findViewById(R.id.edit_course);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_name.getText().toString();
                int course = Integer.parseInt(edit_course.getText().toString());

                RealmManager.getInstance().addStudent(name, course);
                finish();
            }
        });

    }
}
