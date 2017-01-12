package com.lp.iem.internshipmanager.presentation.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lp.iem.internshipmanager.R;
import com.lp.iem.internshipmanager.presentation.navigator.EditNavigator;

import butterknife.ButterKnife;

public class EditActivity extends AppCompatActivity {

    private EditNavigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ButterKnife.bind(this);

        navigator = new EditNavigator(this);
    }

}
