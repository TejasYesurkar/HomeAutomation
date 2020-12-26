package com.sibi.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static ArrayList<ItemData> contacts =new ArrayList<>();
    static RecyclerView rvContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvContacts = findViewById(R.id.rvItem);
        contacts =new ArrayList<>();
        contacts.add(new ItemData("1","Name 1","It's cool",true ));
        contacts.add(new ItemData("1","Name 1","It's cool",true ));
        contacts.add(new ItemData("1","Name 1","It's cool",false ));
        contacts.add(new ItemData("1","Name 1","It's cool",true ));

        GridLayoutManager layoutManager =new GridLayoutManager(getApplicationContext(), 2);

        recycleviewAdapter adapter = new recycleviewAdapter(contacts);
        rvContacts.setLayoutManager(layoutManager);
        rvContacts.setAdapter(adapter);


    }
}