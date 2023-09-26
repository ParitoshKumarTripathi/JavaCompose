package com.free.m3javacompose.components;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.annotation.Nullable;

import com.free.m3javacompose.ui.Color;
import com.free.m3javacompose.ui.Theme;

public class Row extends LinearLayout {
    private static final Context context = Theme.context();
    private LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0);
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
        setLayoutParams(params);
    }

    public Row layout(int width, int height, int weight) {
        params = new LayoutParams(width, height, weight);
        setLayoutParams(params);
        return this;
    }

    public Row onClick(@Nullable OnClickListener l) {
        setOnClickListener(l);
        return this;
    }

    public Row allowClick() {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true);
        setBackgroundResource(typedValue.resourceId);
        setClickable(true);
        return this;
    }

    public Row gravity(int gravity) {
        setGravity(gravity);
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