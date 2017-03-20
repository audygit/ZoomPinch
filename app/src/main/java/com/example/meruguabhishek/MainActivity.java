package com.example.meruguabhishek.zoompinch;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements ScalableListView.TouchHandler{

    private  float scale= 1f;
    ScalableListView recyclerView;
    private List<ListItem> items=new ArrayList<>();
    private ListAdapter adapter;
    private ArrayList<Integer> selectedPositions=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
        recyclerView= (ScalableListView) findViewById(R.id.recycler_view);
        recyclerView.setTouchHandler(MainActivity.this);
        getList();
        adapter=new ListAdapter(MainActivity.this,R.layout.list_item,items);
        recyclerView.setAdapter(adapter);
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (scale>1.03f) {
                    if (!selectedPositions.contains(position)) {
                        selectedPositions.add(position);
                        adapter.setSelectedPositions(selectedPositions);
                        view.setElevation(32);
                    }else {
                        selectedPositions.remove(Integer.valueOf(position));
                        adapter.setSelectedPositions(selectedPositions);
                        view.setElevation(4);
                    }
                }
            }
        });
//        recyclerView.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//                // true: consume touch event
//                // false: dispatch touch event
//                return false;
//            }
//        });
//
    }
    private void getList(){
        items.add(new ListItem("Temple Run","Shek Studio",R.drawable.temple));
        items.add(new ListItem("Adda 52","PokerWorld.Inc",R.drawable.adda));
        items.add(new ListItem("ZigZag","Ketchapp" ,R.drawable.zig));
        items.add(new ListItem("Psych","NoodleCake",R.drawable.psy));
        items.add(new ListItem("Angry Birds","Iyo mam.Inc",R.drawable.angry));
        items.add(new ListItem("Aoe","Age of Empires",R.drawable.aoe));
        items.add(new ListItem("Temple Run","Shek Studio",R.drawable.temple));
        items.add(new ListItem("Adda 52","PokerWorld.Inc",R.drawable.adda));
        items.add(new ListItem("ZigZag","Ketchapp" ,R.drawable.zig));
        items.add(new ListItem("Psych","NoodleCake",R.drawable.psy));

    }

    @Override
    public void onScaleChanged(float scale) {
        this.scale=scale;
        adapter.setScale(scale);
    }
}
