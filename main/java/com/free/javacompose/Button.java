package com.free.javacompose;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.res.ResourcesCompat;

public class Button extends AppCompatButton {
    private static Context context = Theme.context();
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
        setBackground(Theme.getRippleBackground(96.0f));
        setText(text);
        padding(24,16,24,16);
        setGravity(Gravity.CENTER);
        setCompoundDrawablePadding(Theme.px(8));
        setClickable(true);
        setFocusable(true);
    }
    public Button icon(int id) {
        setCompoundDrawablesWithIntrinsicBounds(id, 0, 0, 0);
        return this;
    }

    public Button radius(float radius) {
        setBackground(Theme.getRippleBackground(radius));
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