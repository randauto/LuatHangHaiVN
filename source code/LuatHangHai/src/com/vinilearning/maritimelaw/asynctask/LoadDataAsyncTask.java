package com.vinilearning.maritimelaw.asynctask;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

import com.vinilearning.maritimelaw.activity.DashBoardActivity;
import com.vinilearning.maritimelaw.databases.DatabaseFactory;
import com.vinilearning.maritimelaw.utils.L;

public class LoadDataAsyncTask extends AsyncTask<Void, Void, Void> {
	private Activity context;

	public LoadDataAsyncTask(Activity context) {
		this.context = context;
	}

	@Override
	protected Void doInBackground(Void... params) {
		DatabaseFactory.chapters = DatabaseFactory.getAllChapter(context);

		DatabaseFactory.contents = DatabaseFactory.getAllContent(context);

		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		L.i("So chapter: " + DatabaseFactory.chapters.size());
		L.i("So Dieu: " + DatabaseFactory.contents.size());
		Intent intent = new Intent(context, DashBoardActivity.class);
		context.startActivity(intent);
		context.finish();
	}

}
