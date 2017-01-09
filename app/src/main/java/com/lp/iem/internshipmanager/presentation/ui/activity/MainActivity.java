package com.lp.iem.internshipmanager.presentation.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.navigator.MainNavigator;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.sephiroth.android.library.bottomnavigation.BottomNavigation;

public class MainActivity extends AppCompatActivity {

    private MainNavigator navigator;

    @BindView(R.id.main_activity_bottom_navbar) BottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        navigator = new MainNavigator(this);
        navigator.displayStudentListFragment();


    }
}
