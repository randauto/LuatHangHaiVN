/*
 * Created by: HaiPQ
 * Date: 22-07-2013
 * File name: LayoutUtil.java
 * Packer Name: com.vinicorp.applock.utils
 */
package com.vinilearning.maritimelaw.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;


/**
 * The Class LayoutUtil.
 */
public class LayoutUtil {
	
	private static final String TAG = "LAYOUTUTIL";
	
	/** The m context. */
	private static Context mContext;
	
	/** The display metrics. */
	private static DisplayMetrics displayMetrics;
	
	/** The radio. */
	private static float radio;

	/** The max width. */
	private static float maxWidth = 320;
	
	/** The base width. */
	private static float baseWidth = 480;
	
	/** The radio width dp. */
	private static float radioWidthDp = 1.0f;

	/**
	 * Inits the.
	 *
	 * @param pActivity the activity
	 */
	public static void init(final Context pActivity) {
		mContext = pActivity;
		displayMetrics = mContext.getResources().getDisplayMetrics();
		radio = displayMetrics.densityDpi / 160f;
		
		int width = (displayMetrics.widthPixels < displayMetrics.heightPixels) ? displayMetrics.widthPixels : (displayMetrics.heightPixels + getBarHeight(displayMetrics.densityDpi)); 
		
		final int w = (int) ((float) width / displayMetrics.density);
		
		if (w >= 720) {
			maxWidth = 720;
		} else if (w >= 600) {
			maxWidth = 600;
		} else if (w >= 480) {
			maxWidth = 480;
		} else if (w >= 360) {
			maxWidth = 360;
		} else if (w >= 320) {
			maxWidth = 320;
		} else if (w >= 240) {
			maxWidth = 240;
		}
		L.i(TAG, "density: " + displayMetrics.density +" width: " + width + " maxWidth: + " +  maxWidth);
		radioWidthDp = baseWidth / maxWidth;
	}
	
	public static int getBarHeight(int Dpi) {
		  int result = 48;
		  switch (displayMetrics.densityDpi) {
	    	case DisplayMetrics.DENSITY_XXXHIGH:
	    		L.i(TAG,"DENSITY_XHIGH " + 162);
	    		result = 162;
	         break;
	    	case DisplayMetrics.DENSITY_XHIGH:
	    		 L.i(TAG,"DENSITY_XHIGH " + 108);
	    		 result = 108;
		         break;
	        case DisplayMetrics.DENSITY_HIGH:
	            L.i(TAG,"DENSITY_HIGH " + 72);
	            result = 72;
	            break;
	        case DisplayMetrics.DENSITY_MEDIUM:
	        	 L.i(TAG,"DENSITY_MEDIUM " + 48);
	        	 result = 48;
	            break;
	        case DisplayMetrics.DENSITY_LOW:
	        	 L.i(TAG,"DENSITY_LOW " + 32);
	        	 result = 32;
	            break;
	        default:
	        	 L.i(TAG,"Unknown density");
	        	break;
	    }
		  return result;
		}

	/**
	 * Gets the display.
	 *
	 * @return the display
	 */
	public static DisplayMetrics getDisplay() {
		return displayMetrics;
	}

	/**
	 * Auto Resize View: View, ImageView, TextView, Layout.....
	 *
	 * @param pView the view
	 */
	public static void resizeView(final View pView) {
		final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pView
				.getLayoutParams();
		layoutParams.width = (int) convertDpToPixel(layoutParams.width);
		layoutParams.height = (int) convertDpToPixel(layoutParams.height);
		layoutParams.topMargin = (int) convertDpToPixel(layoutParams.topMargin);
		layoutParams.leftMargin = (int) convertDpToPixel(layoutParams.leftMargin);
		pView.setLayoutParams(layoutParams);
	}

	/**
	 * Resize view.
	 *
	 * @param pView the view
	 * @param width the width
	 * @param height the height
	 * @param top the top
	 * @param left the left
	 */
	public static void resizeView(final View pView, float width, float height,
			float top, float left) {
		final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pView
				.getLayoutParams();
		layoutParams.width = (int) convertDpToPixel(width);
		layoutParams.height = (int) convertDpToPixel(height);
		layoutParams.topMargin = (int) convertDpToPixel(top);
		layoutParams.leftMargin = (int) convertDpToPixel(left);
		pView.setLayoutParams(layoutParams);
	}

	/**
	 * Convert dp to pixel.
	 *
	 * @param dp the dp
	 * @return the float
	 */
	public static float convertDpToPixel(float dp) {
		float px = (dp / radioWidthDp) * radio;
		return px;
	}
	
	public static int truedpToPx(float dp) {
		return Math.round((float)dp * displayMetrics.density);
	}
	
	public static float getMaxWidth(){
		return maxWidth;
	}

	/**
	 * Gets the scale value.
	 *
	 * @param sourceWidth the source width
	 * @return the scale value
	 */
	public float getScaleValue(float sourceWidth) {
		float scale = 1.0f;
		scale = convertDpToPixel(sourceWidth) / sourceWidth;
		return scale;
	}

	/**
	 * Gets the layout.
	 *
	 * @param pArrayLayout the array layout
	 * @return the layout
	 */
	@SuppressLint("Recycle")
	public static int getLayout(int pArrayLayout) {
		int index = 0;
		switch ((int) maxWidth) {
		case 600:
			index = 3;
			break;
		case 480:
			index = 3;
			break;
		case 360:
			index = 2;
			break;
		case 320:
			index = 1;
			break;
		case 240:
			index = 0;
			break;
		default :
			index = 3;
			break;
		}
		return mContext.getResources().obtainTypedArray(pArrayLayout)
				.getResourceId(index, 0);
	}
	
	/**
	 * Gets the layout for more screen size.
	 *
	 * @param pArrayLayout the array layout
	 * @return the layout
	 */
	@SuppressLint("Recycle")
	public static int extraGetLayout(int pArrayLayout) {
		int index = 0;
		switch ((int) maxWidth) {
		
		case 720:
			index = 5;
			break;
		case 600:
			index = 4;
			break;
		case 480:
			index = 3;
			break;
		case 360:
			index = 2;
			break;
		case 320:
			index = 1;
			break;
		case 240:
			index = 0;
			break;
		}
		L.i(TAG, "extraGetLayout index " + index);
		return mContext.getResources().obtainTypedArray(pArrayLayout)
				.getResourceId(index, 0);
	}

	/**
	 * Gets the scale screen.
	 *
	 * @return the scale screen
	 */
	public float getScaleScreen() {
		float index = 1.0f;
		switch ((int) maxWidth) {
		case 720:
			index = 2.25F;
			break;
		case 600:
			index = 1.875F;
			break;
		case 480:
			index = 1.5F;
			break;
		case 360:
			index = 1.125F;
			break;
		case 320:
			index = 1.0F;
			break;
		case 240:
			index = 0.75F;
			break;
		}
		return index;
	}

	/**
	 * Destroy.
	 */
	public void destroy() {
		mContext = null;
		displayMetrics = null;
	}

	/**
	 * Clear activity.
	 *
	 * @param activity the activity
	 * @param rootLayout the root layout
	 */
	public static void clearActivity(Activity activity, int rootLayout) {
		try {
			View view = activity.findViewById(rootLayout);
			if (view != null) {
				unbindViewReferences(view);
				if (view instanceof ViewGroup)
					unbindViewGroupReferences((ViewGroup) view);
			}
			System.gc();
		} catch (Throwable e) {
		}
	}
	
	/**
	 * Clear activity.
	 *
	 * @param activity the activity
	 * @param rootLayout the root View
	 */
	public static void clearActivity(Activity activity, View view) {
		try {
			if (view != null) {
				unbindViewReferences(view);
				if (view instanceof ViewGroup)
					unbindViewGroupReferences((ViewGroup) view);
			}
			System.gc();
		} catch (Throwable e) {
		}
	}

    /**
     * Unbind view.
     *
     * @param view the view
     */
    public static  void unbindView(View view){
        if (view != null) {
            unbindViewReferences(view);
            if (view instanceof ViewGroup)
                unbindViewGroupReferences((ViewGroup) view);
        }
    }

	/**
	 * Unbind view group references.
	 *
	 * @param viewGroup the view group
	 */
	public static void unbindViewGroupReferences(ViewGroup viewGroup) {
		int nrOfChildren = viewGroup.getChildCount();
		for (int i = 0; i < nrOfChildren; i++) {
			View view = viewGroup.getChildAt(i);
			unbindViewReferences(view);
			if (view instanceof ViewGroup)
				unbindViewGroupReferences((ViewGroup) view);
		}
		try {
			viewGroup.removeAllViews();
		} catch (Throwable mayHappen) {
		}
	}
	
	/**
	 * Unbind view references.
	 *
	 * @param view the view
	 */
	@SuppressWarnings("deprecation")
	private static void unbindViewReferences(View view) {
		try {
			view.setOnClickListener(null);
		} catch (Throwable mayHappen) {
		}

		try {
			view.setOnCreateContextMenuListener(null);
		} catch (Throwable mayHappen) {
		}

		try {
			view.setOnFocusChangeListener(null);
		} catch (Throwable mayHappen) {
		}

		try {
			view.setOnKeyListener(null);
		} catch (Throwable mayHappen) {
		}

		try {
			view.setOnLongClickListener(null);
		} catch (Throwable mayHappen) {
		}

		try {
			view.setOnClickListener(null);
		} catch (Throwable mayHappen) {
		}

		if (view instanceof ImageView) {
			setNullImageView((ImageView) view);
		}

		if (view instanceof WebView) {
			/*if(view instanceof i){
			}else{
				try {
					((WebView) view).destroy();
				} catch (Exception e) {
				}
				
			}*/
		}
		
		view.setBackgroundDrawable(null);
		view.destroyDrawingCache();
		if(view.getBackground() != null){
			view.getBackground().setCallback(null);
		}
	}

	/**
	 * Sets the null view.
	 *
	 * @param view the new null view
	 */
	@SuppressWarnings("deprecation")
	public static void setNullView(View view) {
		
		try {
			if (view != null) {
				view.setBackgroundDrawable(null);
				view.destroyDrawingCache();
				view.getBackground().setCallback(null);
				view = null;
			}
		} catch (Exception e) {
		}

	}

	/**
	 * Sets the null image view.
	 *
	 * @param imgView the new null image view
	 */
	@SuppressWarnings("deprecation")
	public static void setNullImageView(ImageView imgView) {
		try {
			if (imgView != null) {
				/*Drawable drawable = imgView.getDrawable();
				if (drawable instanceof BitmapDrawable) {
					BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
					bitmapDrawable.getBitmap().recycle();
				}*/
				imgView.destroyDrawingCache();
				imgView.getBackground().setCallback(null);
				imgView.setBackgroundDrawable(null);
				imgView.setImageBitmap(null);
				imgView.setImageDrawable(null);
				imgView.setBackgroundResource(0);
			}
		} catch (Exception e) {
		}

	}

	
	/**
	 * Override pending transition.
	 *
	 * @param activity the activity
	 */
	public static void overridePendingTransition(Activity activity){
		activity.overridePendingTransition(0, 0);
	}
	
	 /**
	   * Determine if the device is a tablet (i.e. it has a large screen).
	   * 
	   * @param context The calling context.
	   */
	  public static boolean isTablet() {
	    return (mContext.getResources().getConfiguration().screenLayout
	            & Configuration.SCREENLAYOUT_SIZE_MASK)
	            >= Configuration.SCREENLAYOUT_SIZE_LARGE;
	  }
}
