package com.vinilearning.maritimelaw.activity;

import java.util.ArrayList;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.nhaarman.listviewanimations.swinginadapters.AnimationAdapter;
import com.nhaarman.listviewanimations.swinginadapters.prepared.AlphaInAnimationAdapter;
import com.vinilearning.maritimelaw.R;
import com.vinilearning.maritimelaw.adapters.ChapterAdapter;
import com.vinilearning.maritimelaw.adapters.ContentAdapter;
import com.vinilearning.maritimelaw.databases.DatabaseFactory;
import com.vinilearning.maritimelaw.model.MContent;

public class MainActivity extends ActionBarActivity {
	private ListView lvChapter;

	private ChapterAdapter adapterChapter;

	private ContentAdapter adapterContent;

	private AnimationAdapter animationChapterAdapter;

	private AnimationAdapter animationContentAdapter;

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
		animationChapterAdapter = new AlphaInAnimationAdapter(adapterChapter);
		animationChapterAdapter.setAbsListView(lvChapter);
		lvChapter.setAdapter(animationChapterAdapter);

		lvChapter.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (lvChapter.getAdapter() == animationChapterAdapter) {
					// show item of chapter.
					new GetAllContentById().execute(animationChapterAdapter
							.getItemId(position));
				} else {
					// next to screen content activity.
					Intent intent = new Intent(MainActivity.this,
							ContentActivity.class);
					intent.putExtra("id",
							animationContentAdapter.getItemId(position));
					startActivity(intent);
				}
			}

		});
		(new Handler()).postDelayed(new Runnable() {

			@Override
			public void run() {
				loadAdsView();

			}
		}, 1000);
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

	@Override
	public void onBackPressed() {
		if (lvChapter.getAdapter() == animationChapterAdapter) {
			super.onBackPressed();
		} else {
			animationChapterAdapter = new AlphaInAnimationAdapter(
					adapterChapter);
			animationChapterAdapter.setAbsListView(lvChapter);
			lvChapter.setAdapter(animationChapterAdapter);
			getSupportActionBar().setTitle(getString(R.string.app_name));
		}
	}

	class GetAllContentById extends AsyncTask<Long, Void, ArrayList<MContent>> {
		private long id;

		@Override
		protected ArrayList<MContent> doInBackground(Long... params) {
			id = params[0];
			ArrayList<MContent> arr = new ArrayList<MContent>();
			if (DatabaseFactory.chapters != null
					&& DatabaseFactory.contents != null) {
				for (MContent mContent : DatabaseFactory.contents) {
					if (mContent.getParent_id() == id) {
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
			animationContentAdapter = new AlphaInAnimationAdapter(
					adapterContent);
			animationContentAdapter.setAbsListView(lvChapter);
			lvChapter.setAdapter(animationContentAdapter);
			getSupportActionBar().setTitle("Chương " + id);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.search_view, menu);

		SearchManager SManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

		MenuItem searchMenuItem = menu.findItem(R.id.action_search);

		SearchView searchViewAction = (SearchView) MenuItemCompat
				.getActionView(searchMenuItem);
		searchViewAction.setSearchableInfo(SManager
				.getSearchableInfo(getComponentName()));
		return true;
	}

	@Override
	protected void onDestroy() {
		adapterChapter = null;
		animationContentAdapter = null;
		animationChapterAdapter = null;
		adapterContent = null;
		super.onDestroy();
	}
}
