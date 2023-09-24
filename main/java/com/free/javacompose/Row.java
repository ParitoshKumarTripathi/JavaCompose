package com.free.javacompose;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

public class Row extends LinearLayout {
    private static Context context = Theme.context();
    private LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0);
    public Row() {
        super(context);
        init();
    }

    public Row(AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Row(AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(LinearLayout.HORIZONTAL);
        setBackgroundColor(Color.backgroundColor());
    }

    public Row gravity(int gravity) {
        params.gravity = gravity;
        setLayoutParams(params);
        return this;
    }

    public Row margin(int left, int top, int right, int bottom) {
        params.setMargins(Theme.px(left), Theme.px(top), Theme.px(right), Theme.px(bottom));
        setLayoutParams(params);
        return this;
    }

    public Row padding(int left, int top, int right, int bottom) {
        setPadding(Theme.px(left), Theme.px(top), Theme.px(right), Theme.px(bottom));
        return this;
    }

    public Row color(int color) {
        setBackgroundColor(color);
        return this;
    }

    public Row child(View child) {
        super.addView(child);
        return this;
    }
}