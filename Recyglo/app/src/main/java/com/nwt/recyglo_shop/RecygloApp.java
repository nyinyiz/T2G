package com.nwt.recyglo_shop;

import android.app.Application;
import android.content.Context;

public class RecygloApp extends Application {

    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

    }



}
