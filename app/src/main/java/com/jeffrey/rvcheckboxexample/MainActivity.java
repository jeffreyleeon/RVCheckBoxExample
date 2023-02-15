package com.jeffrey.rvcheckboxexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    private Adapter adapter;
    private LinearLayoutManager layoutManager;

    // dummy list of items to be populated manually
    List<Model> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        Adapter adapter = new Adapter();
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        fillItems();

        adapter.loadItems(items);

        // Create an instance of SectionedRecyclerViewAdapter
        SectionedRecyclerViewAdapter sectionAdapter = new SectionedRecyclerViewAdapter();

        List<String> favoritesList = new ArrayList<>();
        favoritesList.add("Fav 1");
        favoritesList.add("Fav 2");

        List<String> contactsList = new ArrayList<>();
        contactsList.add("Contact 1");
        contactsList.add("Contact 2");

        // Create your sections with the list of data
        MySection favoritesSection = new MySection("Favorites", favoritesList);
        MySection contactsSection = new MySection("Add Favorites", contactsList);

        // Add your Sections to the adapter
        sectionAdapter.addSection(favoritesSection);
        sectionAdapter.addSection(contactsSection);

        recyclerView.setAdapter(adapter);
//        recyclerView.setAdapter(sectionAdapter);
    }

    private void fillItems() {
        for (int x = 0; x <=100; x++) {
            Model model = new Model();
            model.setPosition(x+1);

            items.add(model);
        }
    }
}