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

	public static ArrayList<MChapter> getAllChapter(Context context) {
		db = new MyDataBase(context);
		Cursor localCursor = db.getAllChapterFromDb();
		if (localCursor != null) {
			chapters = new ArrayList<MChapter>();
		}

		while (true) {
			if (!localCursor.moveToNext()) {
				localCursor.close();
				db.close();
				return chapters;
			}
			MChapter mChapter = new MChapter(localCursor.getInt(localCursor
					.getColumnIndex(MyDataBase.CHAPTER_ID)),
					localCursor.getString(localCursor
							.getColumnIndex(MyDataBase.CHAPTER_CONTENT)));
			chapters.add(mChapter);
		}
	}

	public static ArrayList<MContent> getAllContent(Context context) {

		return contents;
	}
}
