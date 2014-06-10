package com.vinilearning.maritimelaw.activity;

import java.util.ArrayList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.vinilearning.maritimelaw.R;
import com.vinilearning.maritimelaw.adapters.ChapterAdapter;
import com.vinilearning.maritimelaw.adapters.ContentAdapter;
import com.vinilearning.maritimelaw.databases.DatabaseFactory;
import com.vinilearning.maritimelaw.model.MContent;

public class MainActivity extends ActionBarActivity {
	private ListView lvChapter;

	private ChapterAdapter adapterChapter;

	private ContentAdapter adapterContent;

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

		if (DatabaseFactory.contents == null) {
			DatabaseFactory.contents = DatabaseFactory.getAllContent(this);
		}

		adapterChapter = new ChapterAdapter(this, DatabaseFactory.chapters);
		lvChapter.setAdapter(adapterChapter);

		lvChapter.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (lvChapter.getAdapter() == adapterChapter) {
					// show item of chapter.
					new GetAllContentById().execute(adapterChapter
							.getItemId(position));
				} else {
					// next to screen content activity.

				}
			}

		});

	}

	@Override
	public void onBackPressed() {
		if (lvChapter.getAdapter() == adapterChapter) {
			super.onBackPressed();
		} else {
			lvChapter.setAdapter(adapterChapter);
		}
	}

	class GetAllContentById extends AsyncTask<Long, Void, ArrayList<MContent>> {

		@Override
		protected ArrayList<MContent> doInBackground(Long... params) {
			ArrayList<MContent> arr = new ArrayList<MContent>();
			if (DatabaseFactory.chapters != null
					&& DatabaseFactory.contents != null) {
				for (MContent mContent : DatabaseFactory.contents) {
					if (mContent.getParent_id() == params[0]) {
						arr.add(mContent);
					}
				}
			}
			return arr;
		}

		@Override
		protected void onPostExecute(ArrayList<MContent> result) {
			super.onPostExecute(result);
			adapterContent = new ContentAdapter(MainActivity.this, result);
			lvChapter.setAdapter(adapterContent);
		}

	}
}
