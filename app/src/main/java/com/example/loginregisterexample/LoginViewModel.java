package com.example.loginregisterexample;

import android.app.Activity;

public class LoginViewModel implements IBaseViewModel {
    private Activity mActivity = null;

    public LoginViewModel() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Activity atv) { mActivity = atv; }

    public void onResume() {}

    public void onPause() {}

    public void onDestroy() {}

}
