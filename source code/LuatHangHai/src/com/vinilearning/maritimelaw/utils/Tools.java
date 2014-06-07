package com.vinilearning.maritimelaw.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class Tools {
	private static Tools instance;

	private Context mContext;

	public static Tools getInstance(Context context) {
		if (instance == null) {
			instance = new Tools(context);
		}

		return instance;
	}

	private Tools(Context context) {
		this.mContext = context;
	}

	/**
	 * Method used to navigation to website by your browser.
	 * 
	 * @param url
	 *            of website.
	 */
	public void gotoWebsite(String url) {
		try {
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
			mContext.startActivity(intent);
		} catch (Exception ex) {
			L.e(ex.getMessage());
		}
	}

}
