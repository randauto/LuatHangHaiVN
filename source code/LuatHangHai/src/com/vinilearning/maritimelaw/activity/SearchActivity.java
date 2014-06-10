package com.vinilearning.maritimelaw.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.vinilearning.maritimelaw.R;
import com.vinilearning.maritimelaw.adapters.ContentAdapter;
import com.vinilearning.maritimelaw.databases.DatabaseFactory;
import com.vinilearning.maritimelaw.model.MContent;

public class SearchActivity extends Activity {
	private TextView tvResult;
	private ArrayList<MContent> data;
	private ListView lvContent;
	private ContentAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setTitle(getString(R.string.search_result));
		initView();

		handleIntent(getIntent());
	}

	private void initView() {
		tvResult = (TextView) findViewById(R.id.tvNoResult);
		lvContent = (ListView) findViewById(R.id.listView);
		lvContent.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// next to screen content activity.
				Intent intent = new Intent(SearchActivity.this,
						ContentActivity.class);
				intent.putExtra("id", adapter.getItemId(position));
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
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		handleIntent(intent);
	}

	private void handleIntent(Intent intent) {

		if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
			String query = intent.getStringExtra(SearchManager.QUERY);
			Log.e("Tu khoa: ", "" + query);
			new SearchContent().execute(query.trim());
		}
	}

	class SearchContent extends AsyncTask<String, Void, ArrayList<MContent>> {
		private ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(SearchActivity.this);
			dialog.setMessage(getString(R.string.searching));
			dialog.setCancelable(true);
			dialog.show();
			super.onPreExecute();
		}

		@Override
		protected ArrayList<MContent> doInBackground(String... params) {
			String query = params[0];
			data = new ArrayList<MContent>();
			if (DatabaseFactory.chapters != null
					|| DatabaseFactory.contents != null) {
				if (DatabaseFactory.contents != null) {
					// search by content.
					for (MContent item : DatabaseFactory.contents) {
						if (item.getTitle().contains(query)
								|| item.getContent().contains(query)) {
							data.add(item);
						}
					}
				}
			}
			return data;
		}

		@Override
		protected void onPostExecute(ArrayList<MContent> result) {
			super.onPostExecute(result);
			if (dialog != null && dialog.isShowing()) {
				dialog.dismiss();
				dialog = null;
			}

			if (result == null || result.size() == 0) {
				tvResult.setVisibility(View.VISIBLE);
				return;
			} else {
				tvResult.setVisibility(View.GONE);
			}

			adapter = new ContentAdapter(getBaseContext(), result);
			lvContent.setAdapter(adapter);

		}
	}
}
