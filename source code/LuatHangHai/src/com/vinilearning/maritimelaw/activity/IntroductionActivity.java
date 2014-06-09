package com.vinilearning.maritimelaw.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.view.Menu;

import com.vinilearning.maritimelaw.R;
import com.vinilearning.maritimelaw.common.BaseActivity;
import com.vinilearning.maritimelaw.databases.MyDataBase;
import com.vinilearning.maritimelaw.model.MContent;

public class IntroductionActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.introduction_layout);
		try {
			String[] data = { "1_7.html", "8_44.html", "45_69.html",
					"70_90.html", "91_122.html", "123_142.html",
					"143_168.html", "169_186.html", "187_205.html",
					"206_234.html", "235_261.html" };
			for (int k = 0; k < data.length; k++) {
				StringBuilder buf = new StringBuilder();
				InputStream html = getAssets().open("web/" + data[k]);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						html));
				String str;
				while ((str = in.readLine()) != null) {
					buf.append(str);
				}
				in.close();
				String regularExpression = "<strong></strong>";
				String[] str1_7 = buf.toString().split(regularExpression);
				System.out.println("So cau: " + str1_7.length);
				MyDataBase mDatabase = new MyDataBase(IntroductionActivity.this);
				mDatabase.openWrite();
				for (int i = 0; i < str1_7.length; i++) {
					String content = str1_7[i];
					String[] ar = content.split("<p align=\"justify\">");
					String title = ar[1];
					System.out.println("title: " + "<p align=\"justify\">"
							+ title);

					MContent mContent = new MContent();
					mContent.setParent_id(1);
					mContent.setTitle("<p align=\"justify\">" + title);
					String contentt = "";
					for (int j = 2; j < ar.length; j++) {

						contentt += "<p align=\"justify\">" + ar[j];
					}
					mContent.setContent(contentt);
					System.out.println("id = "
							+ mDatabase.insertContentToDb(mContent));
				}
				mDatabase.close();
				html.close();
			}
			System.out.println("XONG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
}
