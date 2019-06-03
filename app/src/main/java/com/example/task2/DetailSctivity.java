package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailSctivity extends AppCompatActivity {
private TextView names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sctivity);
        names=findViewById(R.id.name);
        Intent intent=getIntent();
        String name = intent.getStringExtra("STATUS");
        names.setText(name);
    }
}
