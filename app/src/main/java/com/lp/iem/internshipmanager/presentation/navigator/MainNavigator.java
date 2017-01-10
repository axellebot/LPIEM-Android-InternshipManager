package com.lp.iem.internshipmanager.presentation.navigator;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.model.Contact;
import com.lp.iem.internshipmanager.presentation.ui.activity.BaseActivityLifeCycle;
import com.lp.iem.internshipmanager.presentation.ui.fragment.StudentDetailsFragment;
import com.lp.iem.internshipmanager.presentation.ui.fragment.StudentListFragment;

/**
 * Created by romai on 09/01/2017.
 */

public class MainNavigator implements BaseActivityLifeCycle {
    public final static int FRAGMENT_STUDENT_LIST = 0;
    public final static int FRAGMENT_STUDENT_DETAILS = 0;

    private int currentFragmentId;

    private FragmentManager fragmentManager;
    private Activity activity;

    private StudentListFragment studentListFragment;

    public MainNavigator(Activity activity) {
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

    public void onBackPressed(){
        if(currentFragmentId == FRAGMENT_STUDENT_DETAILS) {
            fragmentManager.popBackStack();
        }
    }

    public void displayStudentListFragment() {
        if(studentListFragment == null) {
            studentListFragment = StudentListFragment.newInstance();
        }
        else {
            fragmentManager.popBackStack();
        }
        fragmentTransactionReplace(studentListFragment);
        currentFragmentId = FRAGMENT_STUDENT_LIST;
    }

    public void displayStudentDetailsFragment(Contact student) {
        StudentDetailsFragment studentDetailsFragment = StudentDetailsFragment.newInstance();
        fragmentTransactionAdd(studentDetailsFragment);
        currentFragmentId = FRAGMENT_STUDENT_DETAILS;
    }

    public Fragment getCurrentFragment() {
        return fragmentManager.findFragmentById(R.id.main_activity_fragment_container);
    }

    private void fragmentTransactionReplace(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_activity_fragment_container, fragment, fragment.getClass().getName());
        fragmentTransaction.commit();
    }

    private void fragmentTransactionAdd(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_activity_fragment_container, fragment, fragment.getClass().getName());
        fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();
    }
}
