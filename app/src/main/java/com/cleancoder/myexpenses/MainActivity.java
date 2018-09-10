package com.cleancoder.myexpenses;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cleancoder.myexpenses.adapters.RecordAdapter;
import com.cleancoder.myexpenses.data.RecordRepositoryContract;
import com.cleancoder.myexpenses.data.RecordRepositoryImplementation;
import com.cleancoder.myexpenses.models.Account;
import com.cleancoder.myexpenses.models.Category;
import com.cleancoder.myexpenses.models.Record;
import com.cleancoder.myexpenses.models.SubCategory;
import com.cleancoder.myexpenses.models.Type;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecordRepositoryContract recordRepo = new RecordRepositoryImplementation();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.newRecord);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //change view to new Record view
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mRecyclerView = findViewById(R.id.latestRecords);

        // changes in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecordAdapter(recordRepo.getLatest(5));
        mRecyclerView.setAdapter(mAdapter);
    }

}