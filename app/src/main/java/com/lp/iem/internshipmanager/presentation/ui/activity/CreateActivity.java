package com.lp.iem.internshipmanager.presentation.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.navigator.CreateNavigator;

import butterknife.ButterKnife;

public class CreateActivity extends AppCompatActivity {
    public static final String FRAGMENT_TYPE_KEY = "FRAGMENT_TYPE";
    public static final String STUDENT_ID_KEY = "STUDENT_ID";

    public static final int FRAGMENT_CREATE_SCHEDULE = 1;
    public static final int FRAGMENT_CREATE_FILE = 2;

    private CreateNavigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        int fragmentType = intent.getExtras().getInt(FRAGMENT_TYPE_KEY);
        String studentId = intent.getExtras().getString(STUDENT_ID_KEY);

        navigator = new CreateNavigator(this);
        navigator.displayFragmentByType(fragmentType, studentId);
    }

}
