package com.example.loginregisterexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.loginregisterexample.databinding.FragmentRegisterBinding;


public class RegisterFragment extends Fragment {

    private RegisterViewModel vm = new RegisterViewModel();
    private FragmentRegisterBinding vw;

    public RegisterFragment() {
        // Required empty public constructor
    }

    public static RegisterFragment newInstance() {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_mini_bp, container, false);
        vw = DataBindingUtil.inflate(this.getLayoutInflater(), R.layout.fragment_register, container, false);
        vw.setVw(this);
        vw.setVm(vm);
        vm.onCreate(this.getActivity());
        return vw.getRoot();
    }

    @Override
    public void onPause() {
        super.onPause();
        vm.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        vm.onDestroy();
    }

    public void registerToast(){
        Toast.makeText(getContext(), "가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent); //액티비티 이동
    }
}

