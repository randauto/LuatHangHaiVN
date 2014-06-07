package com.vinilearning.maritimelaw.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.vinilearning.maritimelaw.R;
import com.vinilearning.maritimelaw.adapters.ChapterAdapter;
import com.vinilearning.maritimelaw.databases.DatabaseFactory;

public class MainActivity extends ActionBarActivity {
	private ListView lvChapter;

	private ChapterAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
	}

	private void initView() {
		lvChapter = (ListView) findViewById(R.id.listView);

		if (DatabaseFactory.chapters == null) {
			DatabaseFactory.chapters = DatabaseFactory.getAllChapter(this);
		}

		adapter = new ChapterAdapter(this, DatabaseFactory.chapters);
		lvChapter.setAdapter(adapter);

	}

}
