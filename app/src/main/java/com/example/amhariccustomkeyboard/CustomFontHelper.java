package com.example.amhariccustomkeyboard;


import static java.security.AccessController.getContext;

import android.content.Context;
import android.graphics.Typeface;
import android.provider.FontRequest;
import android.provider.Settings;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;

import java.lang.reflect.Field;
import java.security.AccessController;

public class CustomFontHelper {
//
    public static void setDefaultFont(Context context, String staticTypefaceFieldName, String fontAssetName) {
        final Typeface regular = Typeface.createFromAsset(context.getAssets(), fontAssetName);
        Log.d("REGULAR TYPEFACE", "${regular}");
        replaceFont(staticTypefaceFieldName, regular);

        Log.d("FONT CHANGED", Typeface.DEFAULT.toString());
        Log.d("FONT CHANGED", "ANDROID SYSTEM FONT CHANGED TO FULDE FODI");

    }

    protected static void replaceFont(String staticTypefaceFieldName, final Typeface newTypeface) {
        try {
            final Field staticField = Typeface.class.getDeclaredField(staticTypefaceFieldName);
            staticField.setAccessible(true);
            staticField.set(null, newTypeface);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Log.d("FONT REPLACED", "ANDROID SYSTEM FONT REPLACED TO FULDE FODI");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Log.d("FONT REPLACED", "ANDROID SYSTEM FONT FAILED TO REPLACED TO FULDE FODI");
        }


    }

public String changeFont(Context context, String x){
    Typeface tf = Typeface.createFromAsset(context.getAssets(),  "fonts/yourFont.ttf");
    return x;
}
}
