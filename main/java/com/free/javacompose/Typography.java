package com.free.javacompose;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;

public class Typography {
    private static boolean isInitialized = false;
    public static final int HEADING = 0;
    public static final int SUBHEADING = 1;
    public static final int BODY = 2;

    public static void init(Context context) {
        if (!isInitialized) {
            isInitialized = true;
        }
    }
    public static Text applyStyle(Text text, int style) {
        if (style == HEADING){
            text.size(36);
            text.color(Color.textColor());

        } else if (style == SUBHEADING) {
            text.size(20);

        } else if (style == BODY) {
            text.size(16);
            text.color(Color.textColor());
        }

        return text;
    }

    public static class TextStyle {
        private int size;
        private int color;
        private Typeface font;

        public TextStyle(int size, int color, Typeface font) {
            this.size = size;
            this.color = color;
            this.font = font;
        }

        public TextStyle(int size, int color) {
            this.size = size;
            this.color = color;
            this.font = Typeface.DEFAULT;
        }

        public int size() {
            return size;
        }

        public int color() {
            return color;
        }

        public Typeface font() {
            return font;
        }
    }
}
