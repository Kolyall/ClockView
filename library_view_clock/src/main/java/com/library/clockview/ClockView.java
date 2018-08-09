package com.library.clockview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Nick Unuchek on 20.07.2017.
 */

public class ClockView  extends View {
    private Paint mPaint;
    int mClockColor;
    int mHour;
    int mMinute;

    public ClockView(Context context) {
        super(context);
        mClockColor = Color.parseColor("#F44336");
        mHour = 15;
        mMinute = 0;
    }

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupView(context, attrs);
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupView(context, attrs);
    }

    private void setupView(Context context, AttributeSet attrs) {
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.ClockView);
        mClockColor = arr.getColor(R.styleable.ClockView_clockColor, Color.parseColor("#F44336"));
        mHour = arr.getInteger(R.styleable.ClockView_h, 15);
        mMinute = arr.getInteger(R.styleable.ClockView_m, 0);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        arr.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int center_w = (getMeasuredWidth() / 2);
        int center_h = (getMeasuredHeight() / 2);
        int len = (getMeasuredWidth() / 2) - 3;
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(mClockColor);
        canvas.drawCircle(center_w, center_h, len, mPaint);
        mPaint.setColor(mBackgroundColor);
        canvas.drawCircle(center_w, center_h, (float) (int) (len * 0.9), mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth((float) (int) (len * 0.1));
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setColor(mClockColor);
        //mPaint.setColor(getResources().getColor(R.color.textColorSecondary));
        canvas.drawLine(center_w, center_h, center_w + getMinuteX(len), center_h + getMinuteY(len), mPaint);
        //mPaint.setColor(getResources().getColor(R.color.textColorPrimary));
        canvas.drawLine(center_w, center_h, center_w + getHourX(len), center_h + getHourY(len), mPaint);
    }

    public void setHour(int hour) {
        this.mHour = hour;
    }

    public void setMinute(int minute) {
        this.mMinute = minute;
    }

    public void setClockColor(int clockColor) {
        this.mClockColor = clockColor;
    }

    private float getMinuteX(int l) {
        int c = 0;
        if (mMinute < 15) {
            c = mMinute + 45;
        } else {
            c = mMinute - 15;
        }
        double angle = Math.toRadians(c * 6);
        return (float) (0.6 * l * Math.cos(angle));
    }

    private float getMinuteY(int l) {
        int c = 0;
        if (mMinute < 15) {
            c = mMinute + 45;
        } else {
            c = mMinute - 15;
        }
        double angle = Math.toRadians(c * 6);
        return (float) (0.6 * l * Math.sin(angle));
    }

    private float getHourX(int l) {
        double angle = Math.toRadians(((mHour * 60) + mMinute) / 2 - 90);
        return (float) (0.4 * l * Math.cos(angle));
    }

    private float getHourY(int l) {
        double angle = Math.toRadians(((mHour * 60) + mMinute) / 2 - 90);
        return (float) (0.4 * l * Math.sin(angle));
    }


    int mBackgroundColor = Color.WHITE;
    public void setClockBgColor(int backgroundColor) {
        mBackgroundColor = backgroundColor;
    }
}