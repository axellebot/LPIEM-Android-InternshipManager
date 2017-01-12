package com.lp.iem.internshipmanager.presentation.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.navigator.CreateNavigator;

import butterknife.ButterKnife;

public class CreateActivity extends AppCompatActivity {

    private CreateNavigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        ButterKnife.bind(this);

        navigator = new CreateNavigator(this);
    }

}
