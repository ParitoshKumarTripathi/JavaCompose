package com.free.m3javacompose.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ViewFlipper;

import com.free.m3javacompose.ui.Theme;

public class Screen extends ViewFlipper {

    private static final Context context = Theme.context();
    private static boolean REMOVE_CURRENT_SCREEN = false;

    public Screen() {
        super(context);
    }

    public Screen(AttributeSet attrs) {
        super(context, attrs);
    }

    public void show(View v) {
        show(v, false);
    }

    public void show(View v, Boolean b) {
        int i = getDisplayedChild();
        addView(v);
        showNext();
        if (REMOVE_CURRENT_SCREEN){
            removeViewAt(i);
        }
        REMOVE_CURRENT_SCREEN = b;
    }

    public boolean back() {
        int i = getDisplayedChild();
        if (getChildCount() > 1){
            showPrevious();
            if (REMOVE_CURRENT_SCREEN){
                removeViewAt(i);
                REMOVE_CURRENT_SCREEN = false;
            }
            return true;
        }
        return false;
    }
}
