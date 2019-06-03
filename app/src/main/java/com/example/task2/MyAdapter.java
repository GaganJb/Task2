package com.example.task2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private Context context;
        private List<Tasks> tripData;


        public MyAdapter(Context context, List<Tasks> tripData) {
            this.context = context;
            this.tripData = tripData;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.tasklist_items, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            Tasks note = tripData.get(position);

            holder.name.setText(note.getName());
            holder.dis.setText(String.valueOf(note.getDistance()));
            holder.dur.setText(note.getDuration());
        }

        @Override
        public int getItemCount() {
            return tripData.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView name;
            TextView dis;
            TextView dur;

            public MyViewHolder(@NonNull View view) {
                super(view);
                name = view.findViewById(R.id.name);
                dis = view.findViewById(R.id.dis);
                dur = view.findViewById(R.id.dur);
            }
        }
}
