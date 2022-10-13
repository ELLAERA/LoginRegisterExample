package com.example.loginregisterexample;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.loginregisterexample.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding vw;
    private MainViewModel vm = new MainViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vw = DataBindingUtil.setContentView(this, R.layout.activity_main);
        vw.setVw(this);
        vw.setVm(vm);
        vm.onCreate(this);
        Activity act = MainActivity.this;

        setSupportActionBar(vw.settingsToolbar);
        ActionBar abar = getSupportActionBar();
        abar.setTitle("메인화면");
        abar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        vm.onResume();

        Intent intent = getIntent();
        String str_id = intent.getStringExtra("str_id");
        vw.tvId.setText(str_id);

        Intent intent2 = getIntent();
        String str_passWord = intent2.getStringExtra("str_passWord");
        vw.tvPassWord.setText(str_passWord);


        vw.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vw.userDetail.setVisibility(View.VISIBLE);
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        vm.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vm.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case android.R.id.home:
                // 앱바 뒤로가기 버튼...
                finish();
                break;
            default:
                break;
        }
        return true;
    }
}

