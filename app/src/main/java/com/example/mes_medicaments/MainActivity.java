package com.example.mes_medicaments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public static final String NAME = "NAME";
    public static final String DESCR = "DESCRIPTION";
    public static final String TIME = "TIME";
    private FloatingActionButton ajouter_med;
    String name , desrp, time ;
    private TextView nom , description , temps;
    private RecyclerView malist ;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ajouter_med = (FloatingActionButton) findViewById(R.id.add_med);
        ajouter_med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openajouterMed();
            }
        });
        name = getIntent().getStringExtra("nom");
        desrp = getIntent().getStringExtra("description");
        time = getIntent().getStringExtra("time");
        malist = (RecyclerView) findViewById(R.id.malist);
        malist.setLayoutManager(new LinearLayoutManager(this));
        malist.setAdapter(ajouterMed.malistadapter);














    }
    private void openajouterMed(){
        Intent intent = new Intent(this , ajouterMed.class);
        startActivity(intent);

    }



}