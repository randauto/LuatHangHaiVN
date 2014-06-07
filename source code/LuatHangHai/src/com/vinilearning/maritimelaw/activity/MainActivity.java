package com.vinilearning.maritimelaw.activity;

import com.vinilearning.maritimelaw.R;
import com.vinilearning.maritimelaw.R.layout;
import com.vinilearning.maritimelaw.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

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
