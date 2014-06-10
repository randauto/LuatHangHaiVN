package com.vinilearning.maritimelaw;

import android.app.Application;

import com.vinilearning.maritimelaw.utils.T;

public class MaritimeLawApplication extends Application {
	public static final boolean isDebug = true;

	@Override
	public void onCreate() {
		super.onCreate();
		T.init(this);
	}
}
