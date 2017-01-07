package com.example.luoyi.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Leo on 16/6/15.
 */
public class GuideActivity extends Activity {  //使用说明
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_uide);
        findViewById(R.id.btnGuideReturnToTabbed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuideActivity.this.finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayList<String> arrayList=new ArrayList<String>();
        ArrayAdapter<String> adapter;
        ListView listView;
        arrayList.add("第一步: 打开辅助服务");
        adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arrayList);
        listView=(ListView)findViewById(R.id.list_guide);
        listView.setAdapter(adapter);
    }
}
