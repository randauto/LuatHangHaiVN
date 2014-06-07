package com.vinilearning.maritimelaw.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	// Logcat tag
	private static final String LOG = "DatabaseHelper";

	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "maritimelaw.db";

	// Table Names
	private static final String TABLE_CHAPTER = "tblChapter";
	private static final String TABLE_CONTENT = "tblContent";

	// Chapter column names
	private static final String CHAPTER_ID = "_id";
	private static final String CHAPTER_CONTENT = "content";

	// Content column names
	private static final String CONTENT_ID = "_id";
	private static final String CONTENT_PARENT_ID = "parent_id";
	private static final String CONTENT_TEXT = "content";

	// Table Create Statements
	// Todo table create statement
	private static final String CREATE_TABLE_CHAPTER = "CREATE TABLE "
			+ TABLE_CHAPTER + "(" + CHAPTER_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT," + CHAPTER_CONTENT
			+ " TEXT);";

	// Tag table create statement
	private static final String CREATE_TABLE_CONTENT = "CREATE TABLE "
			+ TABLE_CONTENT + "(" + CONTENT_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT," + CONTENT_PARENT_ID
			+ " int," + CONTENT_TEXT + " TEXT," + "FOREIGN KEY ("
			+ CONTENT_PARENT_ID + ") REFERENCES " + TABLE_CHAPTER + "("
			+ CHAPTER_ID + "));";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		// creating required tables
		db.execSQL(CREATE_TABLE_CHAPTER);
		db.execSQL(CREATE_TABLE_CONTENT);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// on upgrade drop older tables
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHAPTER);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTENT);

		// create new tables
		onCreate(db);
	}
}
