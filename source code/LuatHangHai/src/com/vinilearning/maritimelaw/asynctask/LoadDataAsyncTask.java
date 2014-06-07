package com.vinilearning.maritimelaw.asynctask;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

import com.vinilearning.maritimelaw.activity.DashBoardActivity;
import com.vinilearning.maritimelaw.databases.DatabaseFactory;

public class LoadDataAsyncTask extends AsyncTask<Void, Void, Void> {
	private Activity context;

	public LoadDataAsyncTask(Activity context) {
		this.context = context;
	}

	@Override
	protected Void doInBackground(Void... params) {
		DatabaseFactory.chapters = DatabaseFactory.getAllChapter(context);
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		Intent intent = new Intent(context, DashBoardActivity.class);
		context.startActivity(intent);
		context.finish();
	}

}
