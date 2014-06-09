package com.vinilearning.maritimelaw.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.vinilearning.maritimelaw.model.MContent;

public class MyDataBase extends SQLiteAssetHelper {
	private static final String DATABASE_NAME = "luathanghai";
	private static final int DATABASE_VERSION = 1;

	/** Chappter table. */
	public static final String CHAPTER_TABLE = "tblChapter";
	public static final String CHAPTER_ID = "id";
	public static final String CHAPTER_CONTENT = "content";

	/** Content table. */
	public static final String CONTENT_TABLE = "tblContent";
	public static final String CONTENT_ID = "id";
	public static final String CONTENT_PARENTID = "parent_id";
	public static final String CONTENT_TITLE = "title";
	public static final String CONTENT_TEXT = "content";

	private SQLiteDatabase db;

	private final String[] comlumnsContent = { CONTENT_ID, CONTENT_PARENTID,
			CONTENT_TITLE, CONTENT_TEXT };

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

	/**
	 * Method used to get all chapter.
	 * 
	 * @return
	 */
	public Cursor getAllContentFromDb() {
		SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
		SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
		localSQLiteQueryBuilder.setTables(CONTENT_TABLE);
		Cursor localCursor = localSQLiteQueryBuilder.query(localSQLiteDatabase,
				comlumnsContent, null, null, null, null, null);
		localCursor.moveToFirst();
		return localCursor;
	}

	public void close() {
		if (db != null) {
			db.close();
		}
	}

	public void openWrite() {
		if (db == null) {
			db = getWritableDatabase();
		}
	}

	/**
	 * Insert new content to database.
	 * 
	 * @param content
	 * @return
	 */
	public long insertContentToDb(MContent content) {
		ContentValues values = new ContentValues();
		values.put(CONTENT_PARENTID, content.getParent_id());
		values.put(CONTENT_TITLE, content.getTitle());
		values.put(CONTENT_TEXT, content.getContent());
		long rowId = db.insert(CONTENT_TABLE, null, values);
		return rowId;
	}
}
