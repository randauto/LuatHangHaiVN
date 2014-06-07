package com.vinilearning.maritimelaw.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vinilearning.maritimelaw.R;
import com.vinilearning.maritimelaw.model.MChapter;

public class ChapterAdapter extends BaseAdapter {
	ArrayList<MChapter> data;
	private Context context;

	public ChapterAdapter(Context context, ArrayList<MChapter> data) {
		this.data = data;
		this.context = context;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int arg0) {
		return data.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return data.get(arg0).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parentView) {
		MChapter mChapter = data.get(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_chapter, null);
		}

		TextView tvId, tvContent;
		tvId = (TextView) convertView.findViewById(R.id.tvId);
		tvContent = (TextView) convertView.findViewById(R.id.tvContent);

		tvId.setText("Chương " + mChapter.getId());
		tvContent.setText(mChapter.getContent());
		return convertView;
	}

}
