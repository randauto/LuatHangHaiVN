package com.vinilearning.maritimelaw.activity;

import android.os.Bundle;
import android.view.Menu;

import com.vinilearning.maritimelaw.R;
import com.vinilearning.maritimelaw.common.BaseActivity;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
