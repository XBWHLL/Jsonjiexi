package com.example.liu.jsonjiexi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.example.liu.jsonjiexi.adapt.GridviewAdapt;
public class GridLayoutActivity extends AppCompatActivity {
    private GridView gridView;
    private int[] imgs;
    private BaseAdapter adapt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
        gridView= (GridView) findViewById(R.id.main_gridview);
        gridView.setNumColumns(4);
        initdata();
    }
    private void initdata() {
        imgs=new int[]{
                R.mipmap.jinniu,R.mipmap.jinniu,
                R.mipmap.jinniu,R.mipmap.jinniu,
                R.mipmap.jinniu,R.mipmap.jinniu,
                R.mipmap.jinniu,R.mipmap.jinniu,
                R.mipmap.jinniu,R.mipmap.jinniu,
                R.mipmap.jinniu,R.mipmap.jinniu,
        };
        adapt=new GridviewAdapt(GridLayoutActivity.this,imgs);
        gridView.setAdapter(adapt);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
