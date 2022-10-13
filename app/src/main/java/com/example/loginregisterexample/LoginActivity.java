package com.example.loginregisterexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.loginregisterexample.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {


    private ActivityLoginBinding vw;
    private LoginViewModel vm = new LoginViewModel();
    private RegisterFragment fragment = new RegisterFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity act = LoginActivity.this;

        vw = DataBindingUtil.setContentView(this, R.layout.activity_login);
        vw.setVw(this);
        vm.onCreate(this);
        vw.setVm(vm);

        setSupportActionBar(vw.settingsToolbar);
        ActionBar abar = getSupportActionBar();
        abar.setTitle("로그인");

        Button btn_add = (Button) findViewById(R.id.btn_register);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.register_frame, fragment);
                fragmentTransaction.commit();

                View login_frame = findViewById(R.id.login_frame);
                login_frame.setVisibility(View.GONE);
                abar.setTitle("회원가입");
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        vm.onResume();
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


    public void userLogin() {

        String str_id, str_passWord;

        str_id = vw.etId.getText().toString();
        str_passWord = vw.etPassWord.getText().toString();

        if (str_id.equals("") || str_passWord.equals("")) {
            Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
        } else if (str_id.contains(" ") || str_passWord.contains(" ")) {
            Toast.makeText(getApplicationContext(), "공백이 포함되었습니다.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("str_id", str_id);
            intent.putExtra("str_passWord", str_passWord);
            startActivity(intent); //액티비티 이동
        }
    }
}