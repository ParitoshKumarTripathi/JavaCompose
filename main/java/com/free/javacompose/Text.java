package com.free.javacompose;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class Text extends androidx.appcompat.widget.AppCompatTextView {
    private static Context context = Theme.context();
    private LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0);
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

