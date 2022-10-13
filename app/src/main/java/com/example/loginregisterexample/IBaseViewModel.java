package com.example.loginregisterexample;

import android.app.Activity;

public interface IBaseViewModel {
	void onCreate(Activity atv);
	void onResume();
	void onPause();
	void onDestroy();
}
