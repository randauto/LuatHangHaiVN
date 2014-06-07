package com.vinilearning.maritimelaw.utils;

import android.util.Log;

import com.vinilearning.maritimelaw.MaritimeLawApplication;

/**
 * The Class Log.
 */
public class L {

	private static final String TAG = "NFCDaily";

	public static void d(String tag, String msg) {
		if (MaritimeLawApplication.isDebug) {
			Log.d(tag, "" + msg);
		}
	}

	public static void d(String msg) {
		if (MaritimeLawApplication.isDebug) {
			Log.d(TAG, "" + msg);
		}
	}

	public static void i(String tag, String msg) {
		if (MaritimeLawApplication.isDebug) {
			Log.i(tag, "" + msg);
		}
	}

	public static void i(String msg) {
		if (MaritimeLawApplication.isDebug) {
			Log.i(TAG, "" + msg);
		}
	}

	public static void v(String tag, String msg) {
		if (MaritimeLawApplication.isDebug) {
			Log.v(tag, "" + msg);
		}
	}

	public static void v(String msg) {
		if (MaritimeLawApplication.isDebug) {
			Log.v(TAG, "" + msg);
		}
	}

	public static void w(String tag, String msg) {
		if (MaritimeLawApplication.isDebug) {
			Log.w(tag, "" + msg);
		}
	}

	public static void w(String msg) {
		if (MaritimeLawApplication.isDebug) {
			Log.w(TAG, "" + msg);
		}
	}

	public static void e(String tag, String msg) {
		if (MaritimeLawApplication.isDebug && !msg.contains("with a size of")) {
			Log.e(tag, "" + msg);
		}
	}

	public static void e(String msg) {
		if (MaritimeLawApplication.isDebug && !msg.contains("with a size of")) {
			Log.e(TAG, "" + msg);
		}
	}

}
