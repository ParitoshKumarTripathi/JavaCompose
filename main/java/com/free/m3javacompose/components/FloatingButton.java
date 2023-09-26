package com.free.m3javacompose.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout.LayoutParams;

import androidx.annotation.Nullable;

import com.free.m3javacompose.ui.Theme;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FloatingButton extends FloatingActionButton {
    private static final Context context = Theme.context();
    private LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.BOTTOM | Gravity.END);
    public FloatingButton(int resId) {
        super(context);
        init(resId);
    }
    public FloatingButton(int resId, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(resId);
    }

    public FloatingButton(int resId, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(resId);
    }

    private void init(int resId) {
        setImageResource(resId);
        setLayoutParams(params);
    }
    public FloatingButton elevation(float elevation) {
        setCompatElevation(elevation);
        return this;
    }

    public FloatingButton color(int color) {
        setBackgroundColor(color);
        return this;
    }

    public FloatingButton margin(int left, int top, int right, int bottom) {
        params.setMargins(Theme.px(left), Theme.px(top), Theme.px(right), Theme.px(bottom));
        setLayoutParams(params);
        return this;
    }
}
