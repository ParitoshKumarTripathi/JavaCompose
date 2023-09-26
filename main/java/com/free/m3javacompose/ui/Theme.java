package com.free.m3javacompose.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;

import androidx.core.content.res.ResourcesCompat;

import com.free.m3javacompose.ui.Color;

public class Theme {
    private static Context myContext;
    public static void init(Context context) {
        myContext = context;
        Color.init(context);

        //Nav Bar and Status Bar
        Activity activity = (Activity)context;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(Color.backgroundColor());
        window.setStatusBarColor(Color.backgroundColor());
    }

    public static int px(int dp) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                myContext.getResources().getDisplayMetrics()
        );
    }

    public static int pxFromSP(int sp) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP,
                sp,
                myContext.getResources().getDisplayMetrics()
        );
    }

    public static boolean isDarkMode() {
        int currentNightMode = Resources.getSystem().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        return currentNightMode == Configuration.UI_MODE_NIGHT_YES;
    }

    public static Drawable getDrawable(int id) {
        return ResourcesCompat.getDrawable(myContext.getResources(), id, myContext.getTheme());
    }

    public static Context context() {
        return myContext;
    }
}
