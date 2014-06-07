package com.vinilearning.maritimelaw.common;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.vinilearning.maritimelaw.R;

public class BaseActivity extends Activity {
	protected AdView adView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Create an ad.
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				adView = (AdView) findViewById(R.id.adView);
				AdRequest adRequest = new AdRequest.Builder().build();
				adView.loadAd(adRequest);
			}
		}, 1000);
	}
}
