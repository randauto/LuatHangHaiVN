package com.vinilearning.maritimelaw.databases;

import com.vinilearning.maritimelaw.model.MContent;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

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

	private final String[] comlumnsContent = { CONTENT_ID, CONTENT_PARENTID,
			CONTENT_TITLE, CONTENT_TEXT };

	public MContent insertContentToDb(MContent content) {

		return null;
	}
}
