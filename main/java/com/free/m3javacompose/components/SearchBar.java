package com.free.m3javacompose.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.free.m3javacompose.ui.Theme;

public class SearchBar extends com.google.android.material.search.SearchBar {

    private static final Context context = Theme.context();
    private LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0);

    public SearchBar() {
        super(context);
        init();
    }

    public SearchBar(@Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SearchBar(@Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        params.setMargins(0,0,0,0);
        setLayoutParams(params);
    }

    public SearchBar elevation(float elevation) {
        setElevation(elevation);
        return this;
    }

    public SearchBar padding(int left, int top, int right, int bottom) {
        setPadding(Theme.px(left), Theme.px(top), Theme.px(right), Theme.px(bottom));
        return this;
    }
    public SearchBar hint(@Nullable CharSequence hint) {
        setHint(hint);
        return this;
    }
    public SearchBar onClick(@Nullable OnClickListener l) {
        setOnClickListener(l);
        return this;
    }
}
