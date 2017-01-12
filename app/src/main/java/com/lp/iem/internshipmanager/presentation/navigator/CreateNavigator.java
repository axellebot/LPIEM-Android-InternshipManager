package com.lp.iem.internshipmanager.presentation.navigator;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.ui.activity.BaseActivityLifeCycle;
import com.lp.iem.internshipmanager.presentation.ui.fragment.StudentListFragment;


public class CreateNavigator implements BaseActivityLifeCycle {

    private int currentFragmentId;

    private FragmentManager fragmentManager;
    private Activity activity;

    private StudentListFragment studentListFragment;

    public CreateNavigator(Activity activity) {
        this.activity = activity;
        this.fragmentManager = this.activity.getFragmentManager();
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

    public void onBackPressed() {

    }

    public Fragment getCurrentFragment() {
        return fragmentManager.findFragmentById(R.id.main_activity_fragment_container);
    }

    private void fragmentTransactionReplace(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity_add_fragment_container, fragment, fragment.getClass().getName());
        fragmentTransaction.commit();
    }

    private void fragmentTransactionAdd(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.activity_add_fragment_container, fragment, fragment.getClass().getName());
        fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();
    }
}
