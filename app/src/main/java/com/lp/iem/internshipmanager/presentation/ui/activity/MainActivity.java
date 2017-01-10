package com.lp.iem.internshipmanager.presentation.ui.activity;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.model.Contact;
import com.lp.iem.internshipmanager.presentation.navigator.MainNavigator;
import com.lp.iem.internshipmanager.presentation.ui.listener.StudentSelectedListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.sephiroth.android.library.bottomnavigation.BottomNavigation;

public class MainActivity extends AppCompatActivity implements StudentSelectedListener {

    private MainNavigator navigator;

    @BindView(R.id.main_activity_bottom_navbar) BottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigator = new MainNavigator(this);

        bottomNavigation.setOnMenuItemClickListener(new BottomNavigation.OnMenuItemSelectionListener() {
            @Override
            public void onMenuItemSelect(@IdRes int i, int i1, boolean b) {
                switch (i) {
                    case R.id.navbar_menu_students:
                        navigator.displayStudentListFragment();
                        break;
                    case R.id.navbar_menu_leads:

                        break;
                    case R.id.navbar_menu_schedules:

                        break;
                    case R.id.navbar_menu_files:

                        break;
                }
            }
            @Override
            public void onMenuItemReselect(@IdRes int i, int i1, boolean b) {}
        });

        navigator.displayStudentListFragment();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        navigator.onBackPressed();
    }

    @Override
    public void studentSelected(Contact student) {
        navigator.displayStudentDetailsFragment(student);
    }
}
