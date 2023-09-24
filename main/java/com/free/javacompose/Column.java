package com.free.javacompose;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class Column extends LinearLayout {
    private static Context context = Theme.context();
    private LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0);
    public Column() {
        super(context);
        init();
    }

    public Column(AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Column(AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(LinearLayout.VERTICAL);
        setBackgroundColor(Color.backgroundColor());
    }

    public Column gravity(int gravity) {
        params.gravity = gravity;
        setLayoutParams(params);
        return this;
    }

    public Column margin(int left, int top, int right, int bottom) {
        params.setMargins(Theme.px(left), Theme.px(top), Theme.px(right), Theme.px(bottom));
        setLayoutParams(params);
        return this;
    }

    public Column padding(int left, int top, int right, int bottom) {
        setPadding(Theme.px(left), Theme.px(top), Theme.px(right), Theme.px(bottom));
        return this;
    }

    public Column color(int color) {
        setBackgroundColor(color);
        return this;
    }

    public Column child(View child) {
        super.addView(child);
        return this;
    }
}