package com.vinilearning.maritimelaw.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.view.Menu;

import com.vinilearning.maritimelaw.R;
import com.vinilearning.maritimelaw.common.BaseActivity;

public class IntroductionActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.introduction_layout);
		try {
			StringBuilder buf = new StringBuilder();
			InputStream html = getAssets().open("web/1_7.html");
			BufferedReader in = new BufferedReader(new InputStreamReader(html));
			String str;
			while ((str = in.readLine()) != null) {
				buf.append(str);
			}
			in.close();
			String regularExpression = "<strong></strong>"; 
			String[] str1_7 = buf.toString().split(regularExpression);
			System.out.println(str1_7.length);

			for (int i = 0; i < str1_7.length; i++) {
				String content = str1_7[i];
				String[] ar = content.split("<p align=\"justify\">");
				String title = ar[1];
				System.out.println("title: " + "<p align=\"justify\">" + title);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
}
