package com.vinilearning.maritimelaw.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.vinilearning.maritimelaw.R;
import com.vinilearning.maritimelaw.common.BaseActivity;

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
				Intent intent = new Intent(getBaseContext(),
						ContentActivity.class);
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
	}

}
