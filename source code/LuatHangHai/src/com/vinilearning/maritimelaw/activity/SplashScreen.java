package com.vinilearning.maritimelaw.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.vinilearning.maritimelaw.R;

public class SplashScreen extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				Intent intent = new Intent(SplashScreen.this,
						MainActivity.class);
				startActivity(intent);
			}
		}, 2000);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
