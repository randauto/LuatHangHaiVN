package com.vinilearning.maritimelaw.common;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.vinilearning.maritimelaw.R;
import com.vinilearning.maritimelaw.utils.DialogUtils;

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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_aboutus:
			DialogUtils.getInstance(BaseActivity.this).showDialogAboutUs();
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
