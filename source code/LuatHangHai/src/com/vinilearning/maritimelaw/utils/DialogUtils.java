package com.vinilearning.maritimelaw.utils;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.vinilearning.maritimelaw.R;

/**
 * Method used to show dialog.
 * 
 * @author TuanLQ.
 * 
 */
public class DialogUtils {
	private AlertDialog.Builder builder;

	private static DialogUtils instance;

	private Context mContext;

	public static DialogUtils getInstance(Context context) {
		if (instance == null) {
			instance = new DialogUtils(context);
		}

		return instance;
	}

	private DialogUtils(Context context) {
		this.mContext = context;
	}

	public void showOkAlertDialog(String title, String msg) {

		if (builder == null) {
			builder = new Builder(mContext);
		}

		if (!TextUtils.isEmpty(title)) {
			builder.setTitle(title);
		}

		if (!TextUtils.isEmpty(msg)) {
			builder.setMessage(msg);
		}

		builder.setPositiveButton(mContext.getString(android.R.string.ok),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});

		Dialog dialog = builder.create();
		dialog.setCancelable(true);
		dialog.show();
	}

	/**
	 * Method used to show about us dialog.
	 */
	public void showDialogAboutUs() {
		if (builder == null) {
			builder = new Builder(mContext);
		}

		builder.setTitle(mContext.getString(R.string.aboutus));
		builder.setMessage(Html
				.fromHtml(mContext.getString(R.string.about_us_text)));
		builder.setNegativeButton(mContext.getString(R.string.close),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});

		builder.setPositiveButton(mContext.getString(R.string.vote5star),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						final String appPackageName = mContext.getPackageName();
						try {
							mContext.startActivity(new Intent(
									Intent.ACTION_VIEW, Uri
											.parse("market://details?id="
													+ appPackageName)));
						} catch (android.content.ActivityNotFoundException anfe) {
							mContext.startActivity(new Intent(
									Intent.ACTION_VIEW,
									Uri.parse("http://play.google.com/store/apps/details?id="
											+ appPackageName)));
						}
						dialog.dismiss();
					}
				});

		final AlertDialog dialog = builder.create();
		dialog.show();
		dialog.getWindow().getAttributes();
		TextView textView = (TextView) dialog
				.findViewById(android.R.id.message);
		textView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Tools.getInstance(mContext).gotoWebsite(
						mContext.getString(R.string.website_vini).toString());
				dialog.dismiss();
			}
		});

	}

	public void showErrorDialog(String title, String msg) {

		if (builder == null) {
			builder = new Builder(mContext);
		}

		if (!TextUtils.isEmpty(title)) {
			builder.setTitle(title);
		}

		if (!TextUtils.isEmpty(msg)) {
			builder.setMessage(msg);
		}

		builder.setIcon(android.R.drawable.ic_dialog_alert);
		builder.setPositiveButton(mContext.getString(android.R.string.ok),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});

		Dialog dialog = builder.create();
		dialog.setCancelable(true);
		dialog.show();
	}
}
