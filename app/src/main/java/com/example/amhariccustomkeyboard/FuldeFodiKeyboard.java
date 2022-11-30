package com.example.amhariccustomkeyboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

import java.util.List;

public class FuldeFodiKeyboard extends KeyboardView {

    public FuldeFodiKeyboard(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        @SuppressLint("DrawAllocation") Paint mpaint = new Paint();
        mpaint.setTypeface(Typeface.DEFAULT_BOLD); //to make all Bold. Choose Default to make all normal font
        mpaint.setTextSize(24); // in px


        List<Keyboard.Key> keys = getKeyboard().getKeys();
        for (Keyboard.Key key : keys) {
            if (key.label != null) {
                String keyLabel = key.label.toString();
                canvas.drawText(keyLabel, key.x + key.width, key.y + key.height, mpaint);
            } else if (key.icon != null) {
                key.icon.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                key.icon.draw(canvas);
            }
        }
    }
}
