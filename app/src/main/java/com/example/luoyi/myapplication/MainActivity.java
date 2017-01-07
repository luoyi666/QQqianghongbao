package com.example.luoyi.myapplication;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final Intent mAccessibleIntent =  new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
    private Button switchPlugin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化音效
        SoundPlayUtils.init(this);
        switchPlugin = (Button)findViewById(R.id.button_accessible);
        updateServiceStatus();
        Button btnGuide=(Button)findViewById(R.id.btnUseGuide);
        Button btnAbout=(Button)findViewById(R.id.btnAbout);
        btnGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,GuideActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AboatActivity.class);
                startActivity(intent);
            }
        });
    }

    /*开启插件的按钮*/
    public void onButtonClicked(View view) {startActivity(mAccessibleIntent);}

    protected void onResume() {
        super.onResume();
        updateServiceStatus();
    }
    private void updateServiceStatus() {
        boolean serviceEnabled = false;
        AccessibilityManager accessibilityManager = (AccessibilityManager) getSystemService(Context.ACCESSIBILITY_SERVICE);
        List<AccessibilityServiceInfo> accessibilityServices = accessibilityManager.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_GENERIC);
        for (AccessibilityServiceInfo info : accessibilityServices) {
            if (info.getId().equals(getPackageName() + "/.QQHongbaoService")) {
                serviceEnabled = true;
                break;
            }
        }
        if (serviceEnabled) {
            switchPlugin.setText("关闭插件");
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        } else {
            switchPlugin.setText("请点击此处，打开辅助服务");
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);}
    }
}

