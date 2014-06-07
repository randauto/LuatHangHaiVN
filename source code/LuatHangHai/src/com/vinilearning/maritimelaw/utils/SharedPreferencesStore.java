package com.vinilearning.maritimelaw.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.vinilearning.maritimelaw.common.AppConstants;

/**
 * This class utility for store all preference value.
 * 
 */
public class SharedPreferencesStore {

	/** Variable of SharedPreferences. */
	private SharedPreferences prefs;

	private static SharedPreferencesStore sharedPreferStore;

	public static SharedPreferencesStore getInstance(Context context) {
		if (sharedPreferStore == null) {
			sharedPreferStore = new SharedPreferencesStore(context);
		}
		return sharedPreferStore;
	}

	public SharedPreferencesStore(Context context) {
		this.prefs = context.getSharedPreferences(AppConstants.STORE_NAME,
				Context.MODE_PRIVATE);
	}

	/**
	 * This funtion is used for save data to SharedPreferences.
	 * 
	 * @param {key} Key of data.
	 * @param value
	 * @return true if save successful otherwise return false.
	 */
	public boolean putString(String key, String value) {
		Editor editor = this.prefs.edit();
		editor.putString(key, value);
		return editor.commit();
	}

	public boolean putInt(String key, int value) {
		Editor editor = this.prefs.edit();
		editor.putInt(key, value);
		return editor.commit();
	}

	public int getInt(String key) {
		return this.prefs.getInt(key, 0);
	}

	public boolean putBoolean(String key, boolean value) {
		Editor editor = this.prefs.edit();
		editor.putBoolean(key, value);
		return editor.commit();
	}

	public boolean getBoolean(String key) {
		return this.prefs.getBoolean(key, false);
	}

	/**
	 * This function is used for get data from SharedPreferences.
	 * 
	 * @param {key} Key of data.
	 * @return null if not existed otherwise return String value.
	 */
	public String getString(String key) {
		return this.prefs.getString(key, null);
	}

	public boolean delete(String key) {
		Editor editor = this.prefs.edit();
		editor.remove(key);
		return editor.commit();
	}
}
