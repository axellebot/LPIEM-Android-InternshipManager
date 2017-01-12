package com.lp.iem.internshipmanager.presentation.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.navigator.AddNavigator;

import butterknife.ButterKnife;

public class EditActivity extends AppCompatActivity {

    private AddNavigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ButterKnife.bind(this);

        navigator = new AddNavigator(this);
    }

}
