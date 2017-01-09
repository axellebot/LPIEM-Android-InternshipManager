package com.lp.iem.internshipmanager.presentation.ui.activity;

/**
 * Created by romai on 09/01/2017.
 */

public interface BaseActivityLifeCycle {
    void start();
    void resume();
    void pause();
    void stop();
    void destroy();
}
