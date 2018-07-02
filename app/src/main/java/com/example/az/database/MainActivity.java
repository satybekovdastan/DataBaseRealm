package com.example.az.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    Realm realm;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        Button button = findViewById(R.id.button);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);

        realm = Realm.getDefaultInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StudentActivity.class));
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (realm == null){

        }else {
            initRealm();
        }
    }

    private void initRealm() {
        List<Student> list = realm.where(Student.class).findAll();
        RVAdapter rvAdapter = new RVAdapter(this, list);
        recyclerView.setAdapter(rvAdapter);
    }
}
