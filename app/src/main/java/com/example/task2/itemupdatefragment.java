package com.example.task2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class itemupdatefragment extends Fragment {
    View view;
    public itemupdatefragment(){
    }

    RecyclerView recyclerView;
    MyAdapter2 myAdapter2;
    List<UpdateModel> updateModelList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.item_updates,container,false);

        updateModelList=new ArrayList<>();

        Intent intent = getActivity().getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<UpdateModel> object = (ArrayList<UpdateModel>) args.getSerializable("ARRAYLIST");


        recyclerView=view.findViewById(R.id.recyclerview);
        myAdapter2=new MyAdapter2(getContext(),  object);
        recyclerView.setAdapter(myAdapter2);


        return view;
    }
}
