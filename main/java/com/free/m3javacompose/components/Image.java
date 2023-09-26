package com.free.m3javacompose.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;

import com.free.m3javacompose.ui.Theme;

public class Image extends AppCompatImageView {

    private static final Context context = Theme.context();
    private LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0);
    public Image() {
        super(context);
    }

    public Image(AttributeSet attrs) {
        super(context, attrs);
    }

    public Image(AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Image image(int resId) {
        setImageResource(resId);
        return this;
    }

    public Image layout(int width, int height, float weight) {
        params.width = width;
        params.height = height;
        params.weight = weight;
        setLayoutParams(params);
        return this;
    }
    public Image image(Bitmap bitmap) {
        setImageBitmap(bitmap);
        return this;
    }

    public Image gravity(int gravity) {
        params.gravity = gravity;
        setLayoutParams(params);
        return this;
    }

    public Image margin(int left, int top, int right, int bottom) {
        params.setMargins(Theme.px(left), Theme.px(top), Theme.px(right), Theme.px(bottom));
        setLayoutParams(params);
        return this;
    }

    public Image padding(int left, int top, int right, int bottom) {
        setPadding(Theme.px(left), Theme.px(top), Theme.px(right), Theme.px(bottom));
        return this;
    }
}
