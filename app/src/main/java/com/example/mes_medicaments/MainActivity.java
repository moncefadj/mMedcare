package com.example.mes_medicaments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mes_medicaments.adapter.medAdapter;
import com.example.mes_medicaments.models.medData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private static final int ADD_MED_ACTIVITY = 0;

    public static final String NAME = "NAME";
    public static final String DESCR = "DESCRIPTION";
    public static final String TIME = "TIME";
    public static final String TIME2 = "TIME2";
    private FloatingActionButton ajouter_med;
    private TextView nom , description , temps;
    private RecyclerView malist ;
    private MainViewModel viewModel;
    private medAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        adapter =new medAdapter(this,viewModel);
        malist = (RecyclerView) findViewById(R.id.malist);
        malist.setLayoutManager(new LinearLayoutManager(this));
        malist.setAdapter(adapter);
        ajouter_med = (FloatingActionButton) findViewById(R.id.add_med);
        ajouter_med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openajouterMed();
            }
        });

    }
    private void openajouterMed(){
        Intent intent = new Intent(this , ajouterMed.class);
        startActivityForResult(intent, ADD_MED_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_MED_ACTIVITY) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra(NAME);
                String desc = data.getStringExtra(DESCR);
                String time = data.getStringExtra(TIME);
                String time2 = data.getStringExtra(TIME2);

                viewModel.addMed(new medData(name,desc,time,time2,R.drawable.medicine));
                adapter.notifyDataSetChanged();
            }
        }
    }

}