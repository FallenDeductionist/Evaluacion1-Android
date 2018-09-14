package com.fallendeductionist.evaluacion1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<ExampleEmployee> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();

    }

    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleEmployee(R.drawable.picture1, "Helen Skyfall", "Chief Executive Officer", "994 434 567", "Helen.Skyfall@gmail.com", "www.helen.com"));
        mExampleList.add(new ExampleEmployee(R.drawable.picture2, "George kudrov", "Database Manager", "234 545 789", "george.kudrov@gmail.com", "www.george.com"));
        mExampleList.add(new ExampleEmployee(R.drawable.picture3, "Camila Brown", "Back-End Developer", "567 345 232", "camila.brown@gmail.com", "www.camila.com"));
        mExampleList.add(new ExampleEmployee(R.drawable.picture4, "Courtney Auditore", "Front-End Developer", "678 234 210", "courtney.auditore@gmail.com", "www.courtney.com"));
        mExampleList.add(new ExampleEmployee(R.drawable.picture5, "Aidan Piers", "Mobile Developer", "567 745 975", "aidan.piers@gmail.com", "www.aidan.com"));
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

         mAdapter.setOnEmployeeClickListener(new ExampleAdapter.OnEmployeeClickListener() {
             @Override
             public void onEmployeeClick(int position) {
                 Intent intent = new Intent(MainActivity.this, InformationActivity.class);
                 intent.putExtra("Example Employee", mExampleList.get(position));
                 startActivity(intent);
             }
         });
        }


    }

