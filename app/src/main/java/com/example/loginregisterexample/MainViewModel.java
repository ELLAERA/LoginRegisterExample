package com.example.loginregisterexample;

import android.app.Activity;


public class MainViewModel implements IBaseViewModel {
    private Activity mActivity = null;

    public MainViewModel() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Activity atv) { mActivity = atv; }

    public void onResume() {}

    public void onPause() {}

    public void onDestroy() {}
}
