package com.austindroids.recycleaustin.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.austindroids.recycleaustin.R;
import com.austindroids.recycleaustin.adapters.DashboardAdapter;


public class MainActivity extends Activity implements OnItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.dashboard_grid);
        gridview.setAdapter(new DashboardAdapter(this));
        gridview.setOnItemClickListener(this);

        // Hack to disable GridView scrolling
        gridview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return event.getAction() == MotionEvent.ACTION_MOVE;
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        Intent intent;

        switch (position) {
            case 0:
                intent = new Intent(this, ScheduleActivity.class);
                break;
            case 1:
                intent = new Intent(this, RecycleLocationsActivity.class);
                break;
            case 2:
                intent = new Intent(this, FindRecycleServiceActivity.class);
                break;
            case 3:
                intent = new Intent(this, CheckRecyclableActivity.class);
                break;
            default:
                intent = new Intent(this, ScheduleActivity.class);
                break;
        }

        startActivity(intent);
    }
}
