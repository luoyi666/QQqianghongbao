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
public class AboatActivity extends Activity {  //关于软件
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_the_app);
        findViewById(R.id.btnAboutReturnToTabbed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboatActivity.this.finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayList<String> arrayList=new ArrayList<String>();
        ArrayAdapter<String> adapter;
        ListView listView;
        arrayList.add("软件名称:     恭喜发财");
        arrayList.add("版本号:       1.0.0");
        arrayList.add("系统要求:     安卓4.4.4以上");
        arrayList.add("开发者:       罗艺");
        arrayList.add("bug说明:   注意：本应用暂时不支持后台抢红包,");
        arrayList.add("                              要抢红包必须进入红包群。");
        arrayList.add("版权所有,翻版不究");
        adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arrayList);
        listView=(ListView)findViewById(R.id.list_about);
        listView.setAdapter(adapter);
    }
}
