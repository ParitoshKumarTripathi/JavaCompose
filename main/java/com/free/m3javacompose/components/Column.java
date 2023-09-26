package com.free.m3javacompose.components;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.annotation.Nullable;

import com.free.m3javacompose.ui.Color;
import com.free.m3javacompose.ui.Theme;

public class Column extends LinearLayout {
    private static final Context context = Theme.context();
    private LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0);
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
        setLayoutParams(params);
    }
    public Column onClick(@Nullable OnClickListener l) {
        setOnClickListener(l);
        return this;
    }

    public Column allowClick() {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true);
        setBackgroundResource(typedValue.resourceId);
        setClickable(true);
        return this;
    }

    public Column allowScroll() {
        ScrollView sv = new ScrollView(context);
        sv.addView(this);
        Column c = new Column().child(sv);
        c.setLayoutParams(params);
        return c;
    }

    public Column layout(int width, int height, float weight) {
        params = new LayoutParams(width, height, weight);
        setLayoutParams(params);
        return this;
    }

    public Column gravity(int gravity) {
        setGravity(gravity);
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