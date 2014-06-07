package com.vinilearning.maritimelaw.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

public class MyDataBase extends SQLiteAssetHelper {
	private static final String DATABASE_NAME = "luathanghai";
	private static final int DATABASE_VERSION = 1;

	public static final String CHAPTER_TABLE = "tblChapter";
	public static final String CHAPTER_ID = "id";
	public static final String CHAPTER_CONTENT = "content";

	public MyDataBase(Context paramContext) {
		super(paramContext, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/**
	 * Method used to get all chapter.
	 * 
	 * @return
	 */
	public Cursor getAllChapterFromDb() {
		SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
		SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
		String[] arrayOfString = { CHAPTER_ID, CHAPTER_CONTENT };
		localSQLiteQueryBuilder.setTables(CHAPTER_TABLE);
		Cursor localCursor = localSQLiteQueryBuilder.query(localSQLiteDatabase,
				arrayOfString, null, null, null, null, null);
		localCursor.moveToFirst();
		return localCursor;
	}
}
