package com.free.m3javacompose.components;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout.LayoutParams;

import androidx.annotation.Nullable;

import com.free.m3javacompose.ui.Theme;
import com.free.m3javacompose.ui.Typography;

public class Text extends androidx.appcompat.widget.AppCompatTextView {
    private static final Context context = Theme.context();
    private LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0);
    public Text(String text) {
        super(context);
        init(text);
    }

    public Text(String text, AttributeSet attrs) {
        super(context, attrs);
        init(text);
    }

    public Text(String text, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(text);
    }

    private void init(String text){
        setText(text);
        setLayoutParams(params);
    }

    public Text onClick(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
        return this;
    }

    public Text copy() {
        Text clone = new Text(getText().toString());
        clone.setTextColor(getCurrentTextColor());
        clone.setTextSize(TypedValue.COMPLEX_UNIT_PX, getTextSize());
        clone.setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        clone.setLayoutParams(params);
        return clone;
    }

    public Text layout(int width, int height, float weight) {
        params = new LayoutParams(width, height, weight);
        setLayoutParams(params);
        return this;
    }

    public Text style(int style) {;
        return Typography.applyStyle(this, style);
    }

    public Text gravity(int gravity) {
        params.gravity = gravity;
        setLayoutParams(params);
        return this;
    }

    public Text size(int sp) {
        float textSizePx = Theme.pxFromSP(sp);
        setTextSize(TypedValue.COMPLEX_UNIT_PX, textSizePx);
        return this;
    }

    public Text color(int color) {
        setTextColor(color);
        return this;
    }

    public Text margin(int left, int top, int right, int bottom) {
        params.setMargins(Theme.px(left), Theme.px(top), Theme.px(right), Theme.px(bottom));
        setLayoutParams(params);
        return this;
    }

    public Text padding(int left, int top, int right, int bottom) {
        setPadding(Theme.px(left), Theme.px(top), Theme.px(right), Theme.px(bottom));
        return this;
    }
}

