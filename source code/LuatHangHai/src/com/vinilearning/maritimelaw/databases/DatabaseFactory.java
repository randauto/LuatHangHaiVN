package com.vinilearning.maritimelaw.databases;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;

import com.vinilearning.maritimelaw.model.MChapter;
import com.vinilearning.maritimelaw.model.MContent;

public class DatabaseFactory {
	public static MyDataBase db;

	public static ArrayList<MChapter> chapters;

	public static ArrayList<MContent> contents;

	static {
		chapters = null;
		contents = null;
	}

	/**
	 * Method used to get all content.
	 * 
	 * @param context
	 * @return
	 */
	public static ArrayList<MContent> getAllContent(Context context) {
		contents = null;
		db = new MyDataBase(context);
		Cursor localCursor = db.getAllContentFromDb();
		if (localCursor != null) {
			contents = new ArrayList<MContent>();
		}

		if (localCursor.moveToFirst()) {
			do {
				MContent mContent = new MContent(localCursor.getInt(localCursor
						.getColumnIndex(MyDataBase.CONTENT_ID)),
						localCursor.getInt(localCursor
								.getColumnIndex(MyDataBase.CONTENT_PARENTID)),
						localCursor.getString(localCursor
								.getColumnIndex(MyDataBase.CONTENT_TITLE)),
						localCursor.getString(localCursor
								.getColumnIndex(MyDataBase.CONTENT_TEXT)));
				contents.add(mContent);
			} while (localCursor.moveToNext());
		}
		localCursor.close();
		db.close();

		return contents;
	}

	/**
	 * Method used to get all chapter.
	 * 
	 * @param context
	 * @return
	 */
	public static ArrayList<MChapter> getAllChapter(Context context) {
		chapters = null;
		db = new MyDataBase(context);
		Cursor localCursor = db.getAllChapterFromDb();
		if (localCursor != null) {
			chapters = new ArrayList<MChapter>();
		}

		if (localCursor.moveToFirst()) {
			do {
				MChapter mChapter = new MChapter(localCursor.getInt(localCursor
						.getColumnIndex(MyDataBase.CHAPTER_ID)),
						localCursor.getString(localCursor
								.getColumnIndex(MyDataBase.CHAPTER_CONTENT)));
				chapters.add(mChapter);
			} while (localCursor.moveToNext());
		}
		localCursor.close();
		db.close();
		return chapters;
	}
}
