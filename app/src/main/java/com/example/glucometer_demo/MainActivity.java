package com.example.glucometer_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    public DrawerLayout Drawer ;
    NavigationView navigationView;
    static public MainActivity mActivity = null;
    //主页组件
    LinearLayout infomation_layout; //信息组件
    RelativeLayout start_button_layout;

    public void drawerOfBnt(){
        Drawer.open();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drawer = findViewById(R.id.home_id);
        navigationView =findViewById(R.id.nav);
        mActivity = this;

//           设置item图标正常显示
        navigationView.setItemIconTintList(null);
        ImageView bnt = (ImageView) findViewById(R.id.btn_login);
        bnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerOfBnt();
            }
        });
        //获取组件
        infomation_layout = (LinearLayout) findViewById(R.id.infomation_linearLayout);
        start_button_layout = (RelativeLayout) findViewById(R.id.start_button_layout);
        /*
        LinearLayout infomation_layout; //信息组件
        RelativeLayout start_button_layout;
        infomation_layout = (LinearLayout) findViewById(R.id.infomation_linearLayout);
        start_button_layout = (RelativeLayout) findViewById(R.id.start_button_layout);
        Button bnt_start = (Button) findViewById(R.id.start_examination); // 开始检测
        bnt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infomation_layout.setVisibility(View.INVISIBLE);
                LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) start_button_layout.getLayoutParams();
                //params.weight=LinearLayout.LayoutParams.MATCH_PARENT;
                //params.height=1000;
                start_button_layout.setLayoutParams(params);
            }
        });*/
        //添加点击时间
        buttonAddClink();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

//                   为item设置逐个点击事件
//                      switch (menuItem.getItemId()){
//                          case  R.id.nav_camera:{
//                              Toast.makeText(MainActivity.this,"nav_camera",Toast.LENGTH_SHORT).show();
//
//                          }break;
//
//
//                      }
                Toast.makeText(MainActivity.this,menuItem.getTitle().toString(),Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (Drawer.isDrawerOpen(GravityCompat.START)) {
            Drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void buttonAddClink(){
        Button bnt_start = (Button) findViewById(R.id.start_examination); // 开始检测
        bnt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infomation_layout.setVisibility(View.INVISIBLE);
                LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) start_button_layout.getLayoutParams();
                //params.weight=LinearLayout.LayoutParams.MATCH_PARENT;
                //params.height=400;
                start_button_layout.setLayoutParams(params);
            }
        });
    }

    //返回键操作
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            // 想干啥自己写在这里
            if(infomation_layout.getVisibility() == View.INVISIBLE){
                infomation_layout.setVisibility(View.VISIBLE);
            }
            else{
                super.onKeyDown(keyCode, event);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}

