package com.juan.recicleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.AbsListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String>ListaPalabra;
    private PalabrasAdapter adapter;
    private RecyclerView recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaPalabra = new ArrayList<String>();
        for(int i = 0; i < 20; i++) {
            ListaPalabra.add("Palabra " + i);
        }

        recycler = findViewById(R.id.recyclerPalabra);
        adapter = new PalabrasAdapter(ListaPalabra,this);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));

    }
}