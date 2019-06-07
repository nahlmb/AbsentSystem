package com.idn.absentsystem;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;


public class BaseApp extends Application {
    public static String BASE_URL = "http://192.168.71.0/absen_idn/index.php/api/";

    @Override
    public void onCreate() {
        super.onCreate();

        AndroidNetworking.initialize(this);

    }

}
