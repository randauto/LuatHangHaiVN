package com.vinilearning.maritimelaw.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vinilearning.maritimelaw.R;
import com.vinilearning.maritimelaw.model.MContent;

/**
 * Adapter of content
 * 
 * @author TuanLQ.
 * 
 */
public class ContentAdapter extends BaseAdapter {
	private ArrayList<MContent> data;

	private Context context;

	private LayoutInflater inflater;

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
		MContent item = data.get(position);
		ViewHolder holder;
		if (convertView == null) {
			if (inflater == null) {
				inflater = (LayoutInflater) context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			}
			convertView = inflater.inflate(R.layout.item_content, null);
			holder = new ViewHolder();
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
			holder.tvContent = (TextView) convertView
					.findViewById(R.id.tvContent);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.tvTitle.setText(Html.fromHtml(item.getTitle()));
		holder.tvContent.setText(Html.fromHtml(item.getContent()));

		return convertView;
	}

	static class ViewHolder {
		TextView tvTitle;
		TextView tvContent;
	}

}
