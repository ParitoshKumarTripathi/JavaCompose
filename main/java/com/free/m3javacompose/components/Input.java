package com.free.m3javacompose.components;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.free.m3javacompose.ui.Theme;
import com.google.android.material.textfield.TextInputEditText;

public class Input extends TextInputEditText {

    private static final Context context = Theme.context();
    public Input() {
        super(context);
    }

    public Input(@Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Input(@Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Input hint(@Nullable CharSequence hint) {
        setHint(hint);
        clearFocus();
        setFocusableInTouchMode(true);
        return this;
    }
}
