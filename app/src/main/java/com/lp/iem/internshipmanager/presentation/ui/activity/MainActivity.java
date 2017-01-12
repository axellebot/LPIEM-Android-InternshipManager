package com.lp.iem.internshipmanager.presentation.ui.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.navigator.MainNavigator;
import com.lp.iem.internshipmanager.presentation.ui.listener.NavigationListener;
import com.lp.iem.internshipmanager.presentation.ui.listener.StudentSelectedListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.sephiroth.android.library.bottomnavigation.BottomNavigation;

public class MainActivity extends AppCompatActivity implements NavigationListener, StudentSelectedListener {

    private MainNavigator navigator;

    @BindView(R.id.main_activity_bottom_navbar) BottomNavigation bottomNavigation;
    @BindView(R.id.main_activity_fab) FloatingActionsMenu fab;

    private FloatingActionButton addScheduleFab;
    private FloatingActionButton addFileFab;

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
        navigator.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void studentSelected(String studentId) {
        navigator.displayStudentDetailsFragment(studentId);
        setStudentDetailsFab();
    }

    @Override
    public void onStudentDetailsBackPressed() {
        fab.setVisibility(View.GONE);
        fab.removeButton(addScheduleFab);
        fab.removeButton(addFileFab);
    }

    private void setStudentDetailsFab() {
        addScheduleFab = new FloatingActionButton(this);
        addScheduleFab.setIcon(R.drawable.ic_schedule_white_24px);
        addScheduleFab.setSize(FloatingActionButton.SIZE_MINI);
        addScheduleFab.setColorNormalResId(R.color.colorPrimary);
        addScheduleFab.setColorPressedResId(R.color.colorPrimary);
        addScheduleFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.collapse();
                // todo run add add activity with add schedule fragment
            }
        });
        fab.addButton(addScheduleFab);

        addFileFab = new FloatingActionButton(this);
        addFileFab.setIcon(R.drawable.ic_insert_drive_file_white_24dp);
        addFileFab.setSize(FloatingActionButton.SIZE_MINI);
        addFileFab.setColorNormalResId(R.color.colorPrimary);
        addFileFab.setColorPressedResId(R.color.colorPrimary);
        addFileFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.collapse();
                // todo run add add activity with add file fragment
            }
        });
        fab.addButton(addFileFab);

        fab.setVisibility(View.VISIBLE);
    }

}
