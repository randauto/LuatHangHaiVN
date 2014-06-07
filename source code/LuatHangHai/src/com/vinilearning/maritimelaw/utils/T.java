package com.vinilearning.maritimelaw.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

/**
 * The Class Toast.
 */
public class T {

	private static Toast toast;

	@SuppressLint("ShowToast")
	public static void init(Context context) {
		toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
	}

	public static void show(String str) {
		toast.setText(str);
		toast.show();
	}

	public static void show(int str) {
		toast.setText(str);
		toast.show();
	}

	public static void show(String str, int length) {
		toast.setDuration(length);
		toast.setText(str);
		toast.show();
	}

	public static void show(int str, int length) {
		toast.setDuration(length);
		toast.setText(str);
		toast.show();
	}
}
