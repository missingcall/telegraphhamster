package com.aries.smart.module.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

public class MyLeadingMarginSpan2 implements LeadingMarginSpan.LeadingMarginSpan2 {

    private int mMargin;
    private int mLines;

    public MyLeadingMarginSpan2(int margin, int line) {
        this.mMargin = margin;
        this.mLines = line;
    }

    @Override
    public int getLeadingMargin(boolean first) {
        return first ? mMargin : 0;
    }

    @Override
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir, int top,
                                  int baseline, int bottom, CharSequence text, int start, int end,
                                  boolean first, Layout layout) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getLeadingMarginLineCount() {
        return mLines;
    }

}