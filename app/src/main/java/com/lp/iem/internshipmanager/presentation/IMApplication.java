package com.lp.iem.internshipmanager.presentation;

import android.app.Application;

/**
 * Created by romai on 09/01/2017.
 */

public class IMApplication extends Application {
    private static IMApplication application;
    public static IMApplication app() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        initInjection();
    }

    private void initInjection() {

    }
}
