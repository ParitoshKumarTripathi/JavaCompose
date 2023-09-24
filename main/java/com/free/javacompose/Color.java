package com.free.javacompose;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.widget.Toast;

public class Color {
    private static int mainColorLight = 0xFF76D1FF;
    private static int mainColorDark = 0xFF00668B;
    private static int complementColorLight = 0xFFCAC1EA;
    private static int complementColorDark = 0xFF605A7C;

    private static int backgroundColorLight = 0xFFE0F3FF;

    private static int backgroundColorDark = 0xFF001E2C;
    private static final int textColorLight = 0xFFFFFFFF;

    private static final int textColorDark = 0xFF000000;;
    private static boolean isInitialized = false;

    public static void init(Context context) {
        if (!isInitialized) {
            Resources res = context.getResources();

            mainColorLight = res.getColor(android.R.color.system_accent1_200, context.getTheme());
            mainColorDark = res.getColor(android.R.color.system_accent1_600, context.getTheme());
            complementColorLight = res.getColor(android.R.color.system_accent3_200, context.getTheme());
            complementColorDark = res.getColor(android.R.color.system_accent3_600, context.getTheme());
            backgroundColorLight = res.getColor(android.R.color.system_accent1_10, context.getTheme());
            backgroundColorDark = res.getColor(android.R.color.system_accent1_900, context.getTheme());

            isInitialized = true;
        }
    }

    public static int mainColor() {
        return Theme.isDarkMode() ? mainColorDark : mainColorLight;
    }

    public static int complementColor() {
        return Theme.isDarkMode() ? complementColorDark : complementColorLight;
    }

    public static int textColor() {
        return Theme.isDarkMode() ? textColorLight : textColorDark;
    }

    public static int backgroundColor() {
        return Theme.isDarkMode() ? backgroundColorDark : backgroundColorLight;
    }
}