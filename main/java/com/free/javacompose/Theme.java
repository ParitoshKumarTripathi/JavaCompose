package com.free.javacompose;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.Window;

import androidx.core.content.res.ResourcesCompat;

public class Theme {
    private static Context myContext;
    public static void init(Context context) {
        myContext = context;
        Color.init(context);
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

    public static Drawable getRippleBackground(float radius){
        GradientDrawable shapeDrawable = new GradientDrawable();
        shapeDrawable.setCornerRadius(radius);
        shapeDrawable.setColor(Color.mainColor());

        RippleDrawable rippleDrawable = new RippleDrawable(
                ColorStateList.valueOf(Color.backgroundColor()), // Ripple color
                shapeDrawable,
                null
        );

        return rippleDrawable;
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
