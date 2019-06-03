package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kinda.alert.KAlertDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {
    RecyclerView recyclerView;
    MyAdapter mAdapter;
    List<Tasks> tasks;
    Tasks taskobj,taskobj2,taskobj3,taskobj4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recy);
        tasks=new ArrayList<>();
        taskobj = new Tasks("12/03/19","#2234","Hirak Borah",
                "Furniture Repairement",
                "Gagan, Vaibhav, Hirak",
                "Furniture Repairement","14/03/19","15/03/19","3 days"
   ,"FEEDBACK");

        taskobj2 = new Tasks("23/03/19","#2235","Gagan Baishya",
                "Electrical Board",
                "Gagan, Vaibhav, Hirak",
                "Electrician","24/03/19","25/03/19","2 days"
        ,"WORK DUE");

        taskobj3 = new Tasks("1/04/19","#2236","Padmanabha Bhattacharya",
                "Carpentry for lock repairing",
                "Gagan, Himangshu, Hirak",
                "Fire Management","2/04/19","3/04/19","1 days"
        ,"PAYMENT");

        taskobj4 = new Tasks("12/04/19","#2237","Anushree Goswami",
                "Blind for 3 window",
                "Hirak",
                "Fire Management","2/04/19","3/04/19","1 days"
                ,"PAYMENT");

        tasks.add(taskobj);
        tasks.add(taskobj2);
        tasks.add(taskobj3);
        tasks.add(taskobj4);

        mAdapter = new MyAdapter(getApplicationContext(), tasks);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        //for the divider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                ((LinearLayoutManager) layoutManager).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(MainActivity.this);
    }

    @Override
    public void onUpdateClick(int position) {
        Tasks tasks1 = tasks.get(position);
        Intent intent = new Intent(this,DetailSctivity.class);
        intent.putExtra("STATUS",tasks1.getRequirement());
        startActivity(intent);
    }

    @Override
    public void onItemClick(int position) {

        Tasks tasks1 = tasks.get(position);
        new KAlertDialog(this)
                                    .setTitleText("Status")
                                 .setContentText(tasks1.getStatus())
                                    .show();
}
}