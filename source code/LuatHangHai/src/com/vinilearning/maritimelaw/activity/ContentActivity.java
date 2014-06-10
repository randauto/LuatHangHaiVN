package com.vinilearning.maritimelaw.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.widget.TextView;

import com.vinilearning.maritimelaw.R;
import com.vinilearning.maritimelaw.databases.DatabaseFactory;
import com.vinilearning.maritimelaw.model.MContent;

public class ContentActivity extends ActionBarActivity {
	private TextView tvTitle, tvContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content_layout);

		initView();

		setupData();

	}

	private void setupData() {
		Intent intent = getIntent();
		if (intent == null) {
			finish();
			return;
		}

		MContent mContent = null;
		long id = getIntent().getExtras().getLong("id");
		for (MContent item : DatabaseFactory.contents) {
			if (item.getId() == id) {
				mContent = item;
			}
		}

		if (mContent != null) {
			tvTitle.setText(Html.fromHtml(mContent.getTitle()));
			tvContent.setText(Html.fromHtml(mContent.getContent()));
		}
	}

	private void initView() {
		tvTitle = (TextView) findViewById(R.id.tvTitle);
		tvContent = (TextView) findViewById(R.id.tvContent);
	}

	@Override
	protected void onDestroy() {
		tvTitle = null;
		tvContent = null;
		super.onDestroy();
	}

}
