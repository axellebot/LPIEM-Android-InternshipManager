package com.lp.iem.internshipmanager.presentation.navigator;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.ui.activity.BaseActivityLifeCycle;
import com.lp.iem.internshipmanager.presentation.ui.activity.CreateActivity;
import com.lp.iem.internshipmanager.presentation.ui.fragment.CreateFileFragment;
import com.lp.iem.internshipmanager.presentation.ui.fragment.CreateScheduleFragment;


public class CreateNavigator implements BaseActivityLifeCycle {
    public final static int FRAGMENT_CREATE_FILE = 0;
    public final static int FRAGMENT_CREATE_SCHEDULE = 1;

    private int currentFragmentId;

    private FragmentManager fragmentManager;
    private Activity activity;

    public CreateNavigator(Activity activity) {
        this.activity = activity;
        this.fragmentManager = ((CreateActivity) activity).getSupportFragmentManager();
    }

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    public void displayFragmentByType(int fragmentType, String studentId) {
        switch (fragmentType) {
            case CreateActivity.FRAGMENT_CREATE_FILE:
                displayCreateFileFragment(studentId);
                break;
            case CreateActivity.FRAGMENT_CREATE_SCHEDULE:
                displayCreateScheduleFragment(studentId);
                break;
        }
    }

    public void displayCreateFileFragment(String studentId) {
        CreateFileFragment createFileFragment = CreateFileFragment.newInstance(studentId);
        fragmentTransactionReplace(createFileFragment);
        currentFragmentId = FRAGMENT_CREATE_FILE;
    }

    public void displayCreateScheduleFragment(String studentId) {
        CreateScheduleFragment createScheduleFragment = CreateScheduleFragment.newInstance(studentId);
        fragmentTransactionReplace(createScheduleFragment);
        currentFragmentId = FRAGMENT_CREATE_SCHEDULE;
    }


    public void onBackPressed() {
        activity.finish();
    }

    public Fragment getCurrentFragment() {
        return fragmentManager.findFragmentById(R.id.activity_create_fragment_container);
    }

    private void fragmentTransactionReplace(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity_create_fragment_container, fragment, fragment.getClass().getName());
        fragmentTransaction.commit();
    }

    private void fragmentTransactionAdd(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.activity_create_fragment_container, fragment, fragment.getClass().getName());
        fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();
    }
}
