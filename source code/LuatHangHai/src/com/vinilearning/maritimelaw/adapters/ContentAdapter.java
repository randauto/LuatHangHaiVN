package com.vinilearning.maritimelaw.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.vinilearning.maritimelaw.model.MContent;

public class ContentAdapter extends BaseAdapter {
	ArrayList<MContent> data;
	private Context context;

	public ContentAdapter(Context context, ArrayList<MContent> data) {
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

		return null;
	}

}
