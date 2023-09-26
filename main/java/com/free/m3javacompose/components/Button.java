package com.free.m3javacompose.components;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.free.m3javacompose.ui.Theme;
import com.google.android.material.button.MaterialButton;

public class Button extends MaterialButton {
    private static final Context context = Theme.context();
    private LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0);
    public Button(String text) {
        super(context);
        init(text);
    }

    public Button(String text, AttributeSet attrs) {
        super(context, attrs);
        init(text);
    }

    public Button(String text, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(text);
    }

    private void init(String text){
        setText(text);
        setClickable(true);
        setFocusable(true);
        setLayoutParams(params);
    }

    public Button layout(int width, int height, float weight) {
        params.width = width;
        params.height = height;
        params.weight = weight;
        setLayoutParams(params);
        return this;
    }

    public Button onClick(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
        return this;
    }
    public Button icon(int id) {
        setIcon(Theme.getDrawable(id));
        return this;
    }

    public Button radius(int radius) {
        setCornerRadius(Theme.px(radius));
        return this;
    }
    public Button gravity(int gravity) {
        params.gravity = gravity;
        setLayoutParams(params);
        return this;
    }

    public Button size(int sp) {
        float textSizePx = Theme.pxFromSP(sp);
        setTextSize(TypedValue.COMPLEX_UNIT_PX, textSizePx);
        return this;
    }
    public Button color(int color) {
        setBackgroundColor(color);
        return this;
    }

    public Button margin(int left, int top, int right, int bottom) {
        params.setMargins(Theme.px(left), Theme.px(top), Theme.px(right), Theme.px(bottom));
        setLayoutParams(params);
        return this;
    }

    public Button padding(int left, int top, int right, int bottom) {
        setPadding(Theme.px(left), Theme.px(top), Theme.px(right), Theme.px(bottom));
        return this;
    }
}