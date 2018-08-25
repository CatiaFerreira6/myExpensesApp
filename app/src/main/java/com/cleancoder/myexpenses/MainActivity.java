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
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.newRecord);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mRecyclerView = findViewById(R.id.latestRecords);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        List<Record> records = new ArrayList<>();
        records.add(new Record(new Category("code", "description"),new Type("code", "description"),
                new SubCategory("code","description"), new Account("number","description", 23450d), new Date(), "first record", 250.42
                ));

        // specify an adapter (see also next example)
        mAdapter = new RecordAdapter(records);
        mRecyclerView.setAdapter(mAdapter);
    }

}