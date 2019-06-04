package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kinda.alert.KAlertDialog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {
    RecyclerView recyclerView;
    MyAdapter mAdapter;
    List<Tasks> tasks;
    Tasks taskobj, taskobj2, taskobj3, taskobj4;
    UpdateModel model1,model2,model3,model4;
    List<UpdateModel> updateModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recy);
        tasks = new ArrayList<>();
        updateModelList=new ArrayList<>();

        model1=new UpdateModel("123", "#12222", "12/2/12", "IN DUE", "22/22/19", "cse",
                                "Hir", "dd");

        model2=new UpdateModel("321", "#123", "15/2/12", "INVOICE", "31/22/19", "ece",
                "Hira", "ff");

        model3=new UpdateModel("333", "#12322", "14/2/12", "DONE", "31/12/19", "me",
                "Gagan", "Hiraa");

        model4=new UpdateModel("12322", "#121222", "11/2/12", "OK", "21/22/19", "eie",
                "Hirak", "oo");

        updateModelList.add(model1);
        updateModelList.add(model2);
        updateModelList.add(model3);
        updateModelList.add(model4);

        taskobj = new Tasks("12/03/19", "#2234", "Hirak Borah",
                "Furniture Repairement",
                "Gagan, Vaibhav, Hirak",
                "Furniture Repairement", "14/03/19", "15/03/19", "3 days"
                , "FEEDBACK", updateModelList);

        taskobj2 = new Tasks("23/03/19", "#2235", "Gagan Baishya",
                "Electrical Board",
                "Gagan, Vaibhav, Hirak",
                "Electrician", "24/03/19", "25/03/19", "2 days"
                , "WORK DUE",new ArrayList<UpdateModel>());

        taskobj3 = new Tasks("1/04/19", "#2236", "Padmanabha Bhattacharya",
                "Carpentry for lock repairing",
                "Gagan, Himangshu, Hirak",
                "Fire Management", "2/04/19", "3/04/19", "1 days"
                , "PAYMENT",new ArrayList<UpdateModel>());

        taskobj4 = new Tasks("12/04/19", "#2237", "Anushree Goswami",
                "Blind for 3 window",
                "Hirak",
                "Fire Management", "2/04/19", "3/04/19", "1 days"
                , "PAYMENT",new ArrayList<UpdateModel>());

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
        Intent intent = new Intent(this, DetailSctivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("ARRAYLIST",(Serializable)tasks1.getUpdateModelList());
        intent.putExtra("BUNDLE",bundle);
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