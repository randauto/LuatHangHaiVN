package com.vinilearning.maritimelaw.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.vinilearning.maritimelaw.R;
import com.vinilearning.maritimelaw.common.BaseActivity;
import com.vinilearning.maritimelaw.utils.T;

public class DashBoardActivity extends BaseActivity {
	private Button btnTraCuu, btnIntro;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard_layout);

		initView();
	}

	private void initView() {
		btnTraCuu = (Button) findViewById(R.id.btnTraCuu);
		btnIntro = (Button) findViewById(R.id.btnIntro);
		btnTraCuu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getBaseContext(), MainActivity.class);
				startActivity(intent);
			}
		});

		btnIntro.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),
						IntroductionActivity.class);
				startActivity(intent);
			}
		});

		(new Handler()).postDelayed(new Runnable() {

			@Override
			public void run() {
				loadAdsView();

			}
		}, 1000);
	}

	@Override
	protected void onDestroy() {
		btnIntro = null;
		btnTraCuu = null;
		super.onDestroy();
	}

	private boolean doubleBackToExitPressedOnce = false;

	@Override
	public void onBackPressed() {
		if (doubleBackToExitPressedOnce) {
			super.onBackPressed();
			return;
		}

		this.doubleBackToExitPressedOnce = true;
		T.show(getString(R.string.press_again_exit));

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				doubleBackToExitPressedOnce = false;
			}
		}, 2000);
	}

	/**
	 * Method used to load ads view.
	 * 
	 * @param rootView
	 */
	private void loadAdsView() {
		AdView adView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		adView.loadAd(adRequest);
	}

}
